package observer;

import model.Match;

public class PushNotifier implements Notifier {

  @Override
  public void notifyCustomer(Match match) {

    System.out.println("========== PUSH NOTIFICATION ==========");
    System.out.println("Customer : "
        + match.getWantlistEntry().getCustomerId());
    System.out.println("Artist   : "
        + match.getInventoryEvent().getArtist());
    System.out.println("Title    : "
        + match.getInventoryEvent().getTitle());
    System.out.println("Inventory: "
        + match.getInventoryEvent().getInventoryId());
    System.out.println("Match %  : "
        + match.getMatchScore());
    System.out.println("=======================================");

  }

}