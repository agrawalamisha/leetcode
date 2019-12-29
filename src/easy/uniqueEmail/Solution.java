<<<<<<< HEAD
package easy.uniqueEmail;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numUniqueEmails2(String[] emails) {
        Set<String> distinctEmail = new HashSet<>();
        for (String email : emails) {
            String local = email.substring(0, email.indexOf("@"));
            String domain = email.substring(email.indexOf("@") + 1);
            local = local.replace(".", "");
            local = local.substring(0, local.indexOf("+"));
            String filteredEmail = local + "@" + domain;
            distinctEmail.add(filteredEmail);
        }
        System.out.println(distinctEmail);
        return distinctEmail.size();
    }

    public int numUniqueEmails3(String[] emails) {
        Set<String> distinctEmail = new HashSet<>();
        for (String email : emails) {
            String[] address = email.split("@");
            address[0] = address[0].split("\\+")[0];
            address[0] = address[0].replace(".", "");

            distinctEmail.add(address[0] + "@" + address[1]);
        }
        return distinctEmail.size();
    }

    public int numUniqueEmails(String[] emails) {
        if(emails == null || emails.length == 0) {
            return 0;
        }
        Set<String> distinctEmail = new HashSet<>();
        for (String email : emails) {
            boolean localCompleted = false;
            boolean plusFound = false;
            StringBuilder filteredEmail = new StringBuilder();
            for (int i = 0; i < email.length(); i++) {
                if (!localCompleted) {
                    if (email.charAt(i) == '@') {
                        filteredEmail.append(email.charAt(i));
                        localCompleted = true;
                    } else {
                        if (email.charAt(i) == '+' || plusFound) {
                            plusFound = true;
                            continue;
                        }
                        if (email.charAt(i) != '.') {
                            filteredEmail.append(email.charAt(i));
                        }
                    }
                } else {
                    filteredEmail.append(email.charAt(i));
                }
            }
            distinctEmail.add(filteredEmail.toString());
        }
        System.out.println(distinctEmail);
        return distinctEmail.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(solution.numUniqueEmails(arr));
        System.out.println();
    }
}
=======
package easy.uniqueEmail;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numUniqueEmails2(String[] emails) {
        Set<String> distinctEmail = new HashSet<>();
        for (String email : emails) {
            String local = email.substring(0, email.indexOf("@"));
            String domain = email.substring(email.indexOf("@") + 1);
            local = local.replace(".", "");
            local = local.substring(0, local.indexOf("+"));
            String filteredEmail = local + "@" + domain;
            distinctEmail.add(filteredEmail);
        }
        System.out.println(distinctEmail);
        return distinctEmail.size();
    }

    public int numUniqueEmails3(String[] emails) {
        Set<String> distinctEmail = new HashSet<>();
        for (String email : emails) {
            String[] address = email.split("@");
            address[0] = address[0].split("\\+")[0];
            address[0] = address[0].replace(".", "");

            distinctEmail.add(address[0] + "@" + address[1]);
        }
        return distinctEmail.size();
    }

    public int numUniqueEmails(String[] emails) {
        if(emails == null || emails.length == 0) {
            return 0;
        }
        Set<String> distinctEmail = new HashSet<>();
        for (String email : emails) {
            boolean localCompleted = false;
            boolean plusFound = false;
            StringBuilder filteredEmail = new StringBuilder();
            for (int i = 0; i < email.length(); i++) {
                if (!localCompleted) {
                    if (email.charAt(i) == '@') {
                        filteredEmail.append(email.charAt(i));
                        localCompleted = true;
                    } else {
                        if (email.charAt(i) == '+' || plusFound) {
                            plusFound = true;
                            continue;
                        }
                        if (email.charAt(i) != '.') {
                            filteredEmail.append(email.charAt(i));
                        }
                    }
                } else {
                    filteredEmail.append(email.charAt(i));
                }
            }
            distinctEmail.add(filteredEmail.toString());
        }
        System.out.println(distinctEmail);
        return distinctEmail.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(solution.numUniqueEmails(arr));
        System.out.println();
    }
}
>>>>>>> 4727ba8ea448ec78dcd8f94f152c10bbe3064b05
