import java.io.IOException;

/**
 * To construct my own appendable object that will always fail when its methods are used.
 * for testing purposes.
 */
public class MyAppendObject implements Appendable {

  /**
   * To construct my Appendable object.
   */
  public MyAppendObject() {
    //AppendObject
  }

  /**
   * To append the give character sequence to this object (normally).
   * But here it always throws an IOException.
   * @param csq
   *         The character sequence to append.  If {@code csq} is
   *         {@code null}, then the four characters {@code "null"} are
   *         appended to this Appendable.
   *
   * @return always an IO exception
   * @throws IOException always throws because this helps tests when a transmission fails
   */
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("This is supposed to fail");
  }

  /**
   * Normally it would append the given char sequence from start to finish.
   * But for testing purposes, this will always throw an IOException
   * @param csq
   *         The character sequence from which a subsequence will be
   *         appended.  If {@code csq} is {@code null}, then characters
   *         will be appended as if {@code csq} contained the four
   *         characters {@code "null"}.
   *
   * @param start
   *         The index of the first character in the subsequence
   *
   * @param end
   *         The index of the character following the last character in the
   *         subsequence
   *
   * @return an IOException always
   * @throws IOException to help test if a transmission were to fail
   */
  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("This is supposed to fail");
  }

  /**
   * Normally would append the char to this appendable.
   * But as of now it will always throw an IOException to for our testing purposes.
   * @param c
   *         The character to append
   *
   * @return an IOException always
   * @throws IOException everytime to help test a transmission failure.
   */
  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("This is supposed to fail");
  }

}
