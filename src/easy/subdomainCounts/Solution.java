<<<<<<< HEAD
package easy.subdomainCounts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) {
            return list;
        }
        HashMap<String, Integer> subdomainCountMap = new HashMap<>();
        for (String domain : cpdomains) {
            int count = Integer.parseInt(domain.split(" ")[0]);
            String fullDomain = domain.split(" ")[1];
            subdomainCountMap.put(fullDomain, (subdomainCountMap.getOrDefault(fullDomain, 0) + count));
            if (fullDomain.indexOf(".") != -1) {
                String domain2 = fullDomain.substring(fullDomain.indexOf(".") + 1);
                subdomainCountMap.put(domain2, (subdomainCountMap.getOrDefault(domain2, 0) + count));
                if (domain2.indexOf(".") != -1) {
                    String domain3 = domain2.substring(domain2.indexOf(".") + 1);
                    subdomainCountMap.put(domain3, (subdomainCountMap.getOrDefault(domain3, 0) + count));
                }
            }
        }
        for (Map.Entry<String, Integer> entry : subdomainCountMap.entrySet()) {
            list.add(entry.getValue() + " " + entry.getKey());
        }
        return list;
    }
}
=======
package easy.subdomainCounts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) {
            return list;
        }
        HashMap<String, Integer> subdomainCountMap = new HashMap<>();
        for (String domain : cpdomains) {
            int count = Integer.parseInt(domain.split(" ")[0]);
            String fullDomain = domain.split(" ")[1];
            subdomainCountMap.put(fullDomain, (subdomainCountMap.getOrDefault(fullDomain, 0) + count));
            if (fullDomain.indexOf(".") != -1) {
                String domain2 = fullDomain.substring(fullDomain.indexOf(".") + 1);
                subdomainCountMap.put(domain2, (subdomainCountMap.getOrDefault(domain2, 0) + count));
                if (domain2.indexOf(".") != -1) {
                    String domain3 = domain2.substring(domain2.indexOf(".") + 1);
                    subdomainCountMap.put(domain3, (subdomainCountMap.getOrDefault(domain3, 0) + count));
                }
            }
        }
        for (Map.Entry<String, Integer> entry : subdomainCountMap.entrySet()) {
            list.add(entry.getValue() + " " + entry.getKey());
        }
        return list;
    }
}
>>>>>>> 4727ba8ea448ec78dcd8f94f152c10bbe3064b05
