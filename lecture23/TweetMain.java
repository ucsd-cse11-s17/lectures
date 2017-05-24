abstract class ATweet {
             // new field, not in any PA about Tweets
  int likes, quoteCount;
  String content;
  String id;
  abstract String toText();
  ATweet(String content, String id) {
    this.content = content;
    this.id = id;
    this.likes = 0;
    this.quoteCount = 0;
  }
  void like() { this.likes = this.likes + 1; } // FIELD ASSIGNMENT
//      ^ we can like stuff!
  ATweet quote(String content) {
    this.quoteCount += 1; // FIELD ASSIGNMENT
    String quotedId = this.id + this.quoteCount;
    return new QuoteTweet(content, quotedId, this);
  }
}
class TextTweet extends ATweet {
  TextTweet(String content, String id) { super(content, id); }
  String toText() {
    return "(" + this.id + ", "
      + this.likes + " likes, " + this.quoteCount + " quotes) "
      + this.content;
  }
}
class QuoteTweet extends ATweet {
  ATweet quoted;
  QuoteTweet(String content, String id, ATweet quoted) {
    super(content, id);
    this.quoted = quoted;
  }
  String toText() {
    return "(" + this.id + ", "
      + this.likes + " likes, " + this.quoteCount + " quotes) "
      + this.content
      + " [" + this.quoted.content + "]";
  }
}
class TweetMain {
  public static void main(String[] args) {
    ATweet t1 = new TextTweet("Good morning!", "T");
    System.out.println(t1.toText());
    /*
      What will print?

      A: (T1, 0 likes, 1 quotes) Good morning!
      B: (T, 0 likes, 0 quotes) Good morning!
      C: (T, 0 likes, 2 quotes) Good morning!
      D: (T2, 0 likes, 2 quotes) Good morning!
    */

    ATweet q1 = t1.quote("I concur");
    ATweet q2 = t1.quote("Monday is never a good morning.");

    System.out.println(t1.toText());
    /*
      What will print?

      A: (T1, 0 likes, 1 quotes) Good morning!
      B: (T, 0 likes, 0 quotes) Good morning!
      C: (T, 0 likes, 2 quotes) Good morning!
      D: (T2, 0 likes, 2 quotes) Good morning!

      The id of the Tweet referred to by t1 _never changed_
    */
  } }
