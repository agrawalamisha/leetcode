package test;

import java.util.*;

public class JobScheduling {
    public void sort(int[][] ar) {
        Arrays.sort(ar, new Comparator<int[]>() {
            @Override
            public int compare(int[] ar1, int[] ar2) {
                if (ar1[1] > ar2[1]) {
                    return 1;
                } else if (ar1[1] < ar2[1]) {
                    return -1;
                } else {
                    if (ar1[0] > ar2[0]) {
                        return 1;
                    } else if (ar1[0] < ar2[0]) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });
    }

    public int maxEvents(int[] arrival, int[] duration) {
        int[] numEvents = new int[arrival.length];
        Arrays.fill(numEvents, 1);

        int [][] events = new int[arrival.length][2];
        for (int i = 0; i < arrival.length; i++) {
            events[i][0] = arrival[i];
            events[i][1] = arrival[i] + duration[i];
        }

        sort(events);

        for (int i = 1; i < events.length; i++) {
            for (int j = 0; j < i; j++) {
                // do not overlap
                if (events[j][1] <= events[i][0]) {
                    numEvents[i] = Math.max(numEvents[i], numEvents[j] + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numEvents.length; i++) {
            if (numEvents[i] > max) {
                max = numEvents[i];
            }
        }
        return max;
    }

    public int maxEvents2(int[] arrival, int[] duration) {
        int [][] events = new int[arrival.length][2];
        for (int i = 0; i < arrival.length; i++) {
            events[i][0] = arrival[i];
            events[i][1] = arrival[i] + duration[i];
        }
        sort(events);

        int eventCount = 1, currentEventEndTime = events[0][1];
        for (int i = 0; i < events.length - 1; i++) {
            // do not overlap
            if (currentEventEndTime <= events[i + 1][0]) {
                currentEventEndTime = events[i+1][1];
                eventCount++;
            }
        }
        return eventCount;
    }

    public int maxEvents4(int[] start, int[] duration) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < start.length; i++) {
            if (map.keySet().contains(start[i])) {
                ArrayList<Integer> array = new ArrayList<>(map.get(start[i]));
                array.add(duration[i]);
                map.put(start[i], array);
            } else {
                ArrayList list = new ArrayList<Integer>();
                list.add(duration[i]);
                map.put(start[i], list);
            }
        }
        int eventCount = 0;
        boolean isEvent = false;
        int earliestFinish = 2001;
        int currTime = 0;
        while (true) {
            isEvent = false;
            earliestFinish = 2001;
            for (Integer i: map.keySet()) {
                if (i >= currTime) {
                    isEvent = true;
                    for (Integer dur: map.get(i)) {
                        if (i + dur < earliestFinish) {
                            earliestFinish = i + dur;
                        }
                    }
                }
            }

            if (isEvent) {eventCount++;}
            else {break;}
            currTime = earliestFinish;
        }
        return eventCount;
    }

    public static void main(String[] args) {
        int[] arrivals = {1, 1, 1, 1, 4};//{1,3,5};
        int[] departures = {10, 3, 6, 4, 2};

        List<Integer> arr = new ArrayList<Integer>();
        List<Integer> dep = new ArrayList<Integer>();
        for (int i = 0; i < arrivals.length; i++) {
            arr.add(arrivals[i]);
            dep.add(departures[i]);
        }
        JobScheduling j = new JobScheduling();
        System.out.println(j.maxEvents(arrivals, departures));
        System.out.println(j.maxEvents2(arrivals, departures));
        System.out.println(j.maxEvents3(arr, dep));
        System.out.println(j.maxEvents4(arrivals, departures));
    }


    public static int maxEvents3(List<Integer> arrival, List<Integer> duration) {

        int[][] events = new int[arrival.size()][2];

        for (int i = 0; i < arrival.size(); i++) {
            events[i][0] = arrival.get(i);
            events[i][1] = arrival.get(i) + duration.get(i);
        }

        Arrays.sort(events, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2){
                if(arr1[1] == arr2[1]){
                    return (arr1[1] - arr1[0]) - (arr2[1] - arr2[0]);
                }
                return arr1[1] - arr2[1];
            }
        });


        int totalEvents = 0;
        int currentEventEndTime = events[0][1];

        for(int i=0; i<events.length-1; i++){
            if(currentEventEndTime <= events[i+1][0]){
                currentEventEndTime = events[i+1][1];
                totalEvents++;
            }
        }

        return totalEvents + 1;

    }

    /*
    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        int[][] events = new int[arrival.size()][2];
        for (int i = 0; i < arrival.size(); i++) {
            events[i][0] = arrival.get(i);
            events[i][1] = arrival.get(i) + duration.get(i);
        }
        //System.out.println("before sort: "+Arrays.deepToString(events));
        Arrays.sort(events, (a, b) -> (a[0]-b[0]));
        //System.out.println("after sort: "+Arrays.deepToString(events));
        int totalEvents = 0;
        int currentEventEndTime = events[0][1];

        for(int i=1;i<events.length-1;i++){
            if(currentEventEndTime <= events[i+1][0]){
                currentEventEndTime = events[i+1][1];
                totalEvents++;
            }
        }
        return totalEvents+1;

    }

    * */
}
