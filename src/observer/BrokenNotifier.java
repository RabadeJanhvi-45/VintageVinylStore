package observer;

import model.Match;

public class BrokenNotifier implements Notifier {

  @Override
  public void notifyCustomer(Match match) {

    throw new RuntimeException("Email Server Down");

  }

}