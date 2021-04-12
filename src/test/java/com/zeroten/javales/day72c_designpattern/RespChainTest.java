package com.zeroten.javales.day72c_designpattern;

/**
 * 责任链模式案例
 */
public class RespChainTest {

    static abstract class Filter {

        private Filter next;

        public abstract boolean doFilter(String request);

    }

    static class LengthFilter extends Filter {

        @Override
        public boolean doFilter(String request) {

             if (request == null || request.length() < 10) {

                 System.out.println("length < 10");
                 return false;
             }
            return true;
        }
    }

    static class BadNameFilter extends Filter {

        @Override
        public boolean doFilter(String request) {

            if (request.contains("bad")) {

                System.out.println("contains bad content");
                return false;
            }

            return true;
        }
    }

    static class FilterChain {

        private Filter first;

        public void addFilter(Filter filter) {

            if (filter == null) return;

            if (first == null) {

                first = filter;
            } else {

                Filter tmp = first;

                while (tmp.next != null) {

                    tmp = tmp.next;
                }

                tmp.next = filter;
            }
        }

        public void doWork(String request) {

            if (first != null) {

                Filter filter = first;

                while (filter != null) {

                    if (!filter.doFilter(request)) {

                        return;
                    }

                    filter = filter.next;

                }
            }

            // 或
//            if (first != null) {
//
//                while (first != null) {
//
//                    if (!first.doFilter(request)) {
//
//                        return;
//                    }
//
//                    first = first.next;
//
//                }
//            }

            System.out.println(request);
        }
    }

    public static void main(String[] args) {

        String request = "abcdba111111";

        FilterChain filterChain = new FilterChain();

        filterChain.addFilter(new LengthFilter());

        filterChain.addFilter(new BadNameFilter());

        filterChain.doWork(request);
    }
}
