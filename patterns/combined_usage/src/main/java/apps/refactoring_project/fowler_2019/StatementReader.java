package apps.refactoring_project.fowler_2019;

import apps.refactoring_project.fowler_2019.pojo.Invoice;
import apps.refactoring_project.fowler_2019.pojo.Performance;
import apps.refactoring_project.fowler_2019.pojo.Play;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Map;

public class StatementReader {

    public String statement(Invoice invoice, Map<String,Play> plays) {
        int totalAmount = 0;
        int volumeCredits = 0;
        StringBuilder result = new StringBuilder("Statement for " + invoice.getCustomer() + "\n");

        Currency usd = Currency.getInstance("USD");
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        format.setCurrency(usd);

        for (Performance perf : invoice.getPerformances()) {
            Play play = plays.get(perf.getPlayID());

            int thisAmount = 0;

            thisAmount = amountFor(perf, play);

            // add volume credits
            volumeCredits += Math.max(perf.getAudience() - 30, 0);
            // add extra credit for every ten comedy attendees
            if("comedy" == play.getType())
                volumeCredits += Math.floor(perf.getAudience() / 5);

            // print line for this order
            result.append("\t")
                    .append(play.getName()).append(":")
                    .append(format.format(thisAmount / 100)).append(" ").append(usd.getCurrencyCode())
                    .append(" (").append(perf.getAudience()).append(" seats)")
                    .append("\n");

            totalAmount += thisAmount;
        }

        result.append("Amount owed is ").append(format.format(totalAmount / 100)).append(" ").append(usd.getCurrencyCode())
                .append("\n").append("You earned ").append(volumeCredits).append(" credits").append("\n");

        return result.toString();
    }

    private int amountFor(Performance performance, Play play) {
        int result;
        switch (play.getType()) {
            case "tragedy":
                result = 40000;
                if (performance.getAudience() > 30) {
                    result += 1000 * (performance.getAudience() - 30);
                }
                break;
            case "comedy":
                result = 30000;
                if (performance.getAudience() > 20) {
                    result += 10000 + 500 * (performance.getAudience() - 20);
                }
                result += 300 * performance.getAudience();
                break;
            default:
                throw new IllegalStateException("Unknown type: " + play.getType());
        }
        return result;
    }
}
