package extra;

/*
    A short program that generates an array of sentences of a specific pattern
    and then prints them to the console. The pattern is "<pronoun> <verb> <noun>."
*/
public class SentenceExample {
    public static void main(String[] args) {
        //Below are 3 separate arrays for each word type. We are going to build an array of sentences.
        //Each sentence will be constructed by selecting a random word from each word array.
        String[] pronouns = {"He", "She", "It"};
        String[] verbs = {"likes", "hates", "loves", "enjoys", "detests"};
        String[] nouns = {"dogs", "cats", "cars", "computers", "cartoons", "elephants"};

        //Lets make 10 random sentences and store them in the following array:
        String[] sentences = new String[10];

        //Now, let's fill our array with random sentences
        for(int i=0; i < sentences.length; i++) {
            //Select a random word from each word array
            String randomPronoun = pronouns[(int)(Math.random()*pronouns.length)];
            String randomVerb = verbs[(int)(Math.random()*verbs.length)];
            String randomNoun = nouns[(int)(Math.random()*nouns.length)];

            //Build a random sentence from our selected words
            String randomSentence = randomPronoun + ' ' + randomVerb + ' ' + randomNoun + '.';

            //Store this sentence in our sentence array
            sentences[i] = randomSentence;
        }

        //Print each sentence to the console to verify our program is working:
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}
