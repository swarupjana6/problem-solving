package com.practice.problems.amex;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem3 {

    List<String> months = List.of("2020-01-01", "2020-02-01", "2020-03-01", "2020-04-01", "2020-05-01", "2020-06-01",
            "2020-07-01", "2020-08-01", "2020-09-01", "2020-10-01", "2020-11-01", "2020-12-01");

    public static void main(String[] args) {
        int[] A;
        String[] D;

        A = new int[]{100, 100, 100, -10};
        D = new String[]{"2020-12-31", "2020-12-22", "2020-12-03", "2020-12-29"};
        new Problem3().solve(A, D);
    }

    private int solve(final int[] A, final String[] D) {
        if (A == null || D == null || A.length != D.length) throw new IllegalArgumentException("Incorrect input");

        Map<LocalDate, List<Transaction>> byMonth = IntStream.range(0, A.length)
                .mapToObj(i -> new Transaction(A[i], LocalDate.parse(D[i])))
                .collect(Collectors.groupingBy(tnx -> tnx.getDate()
                        .with(TemporalAdjusters.firstDayOfMonth())));


        Map<String, Integer> results = new HashMap<>();
        for (Map.Entry<LocalDate, List<Transaction>> entry : byMonth.entrySet()) {
            AtomicInteger total = new AtomicInteger(0);
            AtomicInteger totalCardAmount = new AtomicInteger(0);
            AtomicInteger cardCount = new AtomicInteger(0);
            entry.getValue().forEach(tnx -> {
                if (tnx.getAmount() < 0) {
                    totalCardAmount.addAndGet(tnx.getAmount());
                    cardCount.incrementAndGet();
                }
                total.addAndGet(tnx.getAmount());
                System.out.println(tnx);
            });

            if (Math.abs(totalCardAmount.get()) < 100 && cardCount.get() < 3) {
                total.addAndGet(-5);
            }
            results.put(entry.getKey().toString(), total.get());
        }


        AtomicInteger totalResult = new AtomicInteger(0);
        for (String month : months) {
            if (results.containsKey(month)) {
                totalResult.addAndGet(results.get(month));
            } else {
                totalResult.addAndGet(-5);
            }
        }

        return totalResult.get();
    }

    class Transaction {
        private int amount;

        public Transaction(int amount, LocalDate date) {
            this.amount = amount;
            this.date = date;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        private LocalDate date;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "amount=" + amount +
                    ", date=" + date +
                    '}';
        }
    }
}
