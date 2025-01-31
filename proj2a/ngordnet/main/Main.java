package ngordnet.main;

import ngordnet.hugbrowsermagic.HugNgordnetServer;
import ngordnet.ngrams.NGramMap;

public class Main {
    public static void main(String[] args) {
        HugNgordnetServer hns = new HugNgordnetServer();

        /* The following code might be useful to you.

        String wordFile = "./data/ngrams/top_14377_words.csv";
        String countFile = "./data/ngrams/total_counts.csv";
        NGramMap ngm = new NGramMap(wordFile, countFile);

        */
        NGramMap map = new NGramMap("./data/ngrams/top_14377_words.csv",
                "./data/ngrams/total_counts.csv");

        hns.startUp();
        hns.register("history", new HistoryHandler(map));
        hns.register("historytext", new HistoryTextHandler(map));
    }
}
