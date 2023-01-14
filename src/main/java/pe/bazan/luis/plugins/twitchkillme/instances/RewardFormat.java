package pe.bazan.luis.plugins.twitchkillme.instances;

public class RewardFormat {
  final private String name;
  final private String username;
  final private String amount;
  final private String method;

  public RewardFormat(
          String name,
          String username,
          String amount,
          String method
  ) {
    this.name = name;
    this.username = username;
    this.amount = amount;
    this.method = method;
  }

  public String replace(String text) {
    text = text.replaceAll("%name%", name);
    text = text.replaceAll("%username%", username);
    text = text.replaceAll("%amount%", amount);
    text = text.replaceAll("%method%", method);
    return text;
  }
}
