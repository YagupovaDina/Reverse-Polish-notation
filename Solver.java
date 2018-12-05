package task3;

import java.io.*;


public class Solver {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        String text;
        text = in.readLine();
        ExpressionEvaluation tmp = new ExpressionEvaluation();
        out.println(tmp.parseAndCalc(text));
        out.flush();
    }
}
