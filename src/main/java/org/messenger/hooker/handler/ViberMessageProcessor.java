package org.messenger.hooker.handler;

import lombok.NoArgsConstructor;
import org.messenger.hooker.interfaces.MessageProcessor;
import org.messenger.hooker.models.viber.Button;
import org.messenger.hooker.models.IncomingMessage;
import org.messenger.hooker.models.viber.Keyboard;
import org.messenger.hooker.models.OutgoingMessage;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


@NoArgsConstructor
public class ViberMessageProcessor implements MessageProcessor {
    final String START_CONVERSATION = "conversation_started";
    final String MESSAGE = "message";


    private IncomingMessage incomingMessage = null;


    private OutgoingMessage outgoingMessage = new OutgoingMessage();
    @Autowired
    private ViberSenderHandler viberSenderHandler;



    @Override
    public MessageProcessor setMessage(IncomingMessage incomingMessage) {
        this.incomingMessage = incomingMessage;
        return this;
    }

    @Override
    public ViberMessageProcessor startProcess() {
        // check event is not null or value is normal
        String event = incomingMessage.getEvent();
        // check have we chatId in incomnig message for answer on it;


        if (event != null) {
            switch (event) {
                case (START_CONVERSATION): {
                    String chatId = (incomingMessage.getUser() != null) ? incomingMessage.getUser().getId() : null;
                    if (chatId != null) {
                        eventStartConversation();
                    }
                    break;
                }
                case (MESSAGE): {
                    ParsingMessage();
                    break;
                }
            }
        }

        return this;
    }

    private void ParsingMessage() {
        String text = incomingMessage.getMessage().getText();
        switch (text) {
            case "/button_menu": {
                ButtonMenuClick();
                break;
            }
            case "/button_menu_eat": {
                ButtonMenuClick();
                ButtonMenu_eatMenu();
                break;
            }
            case "/button_menu_drinklight": {
                ButtonMenuClick();
                ButtonMenu_LightDrink();
                break;
            }
            case "/button_menu_drinkhard": {
                ButtonMenuClick();
                ButtonMenu_HardDrink();
                break;
            }
            case "/button_menu_allImg": {
                ButtonMenu_eatMenu();
                viberSenderHandler.sendAnswer(outgoingMessage);
                ButtonMenu_LightDrink();
                viberSenderHandler.sendAnswer(outgoingMessage);
                ButtonMenuClick();
                ButtonMenu_HardDrink();
                break;
            }


            default: {
//                String describe = "Я только появился на свет, и не понимаю всего, что ты мне пишешь. Но я выучусь, обязательно.  ";
//                String name = incomingMessage.getSender().getName();
//                name = (name == null) ? "друг" : name;
//                String bodyText = "Прости " + name + "." + "\n" + describe;

                outgoingMessage.setText("Меню ниже, выбирай - а лучше заходи ! ");
                outgoingMessage.setType("text");
                outgoingMessage.setReceiver(incomingMessage.getSender().getId());
                outgoingMessage.setMin_api_version(incomingMessage.getSender().getApiVersion());
                Keyboard keyboard = new Keyboard();
                keyboard.setDefaultHeight(true);

                ArrayList<Button> buttons = new ArrayList<>();
                buttons.add(new Button().setColumns(2)
                        .setRows(1)
                        .setText("О нас !")
                        .setActionType("reply")
                        .setBgColor("#2db9b9")
                        .setActionBody("/abount_info"));

                buttons.add(new Button().setColumns(2)
                        .setRows(1)
                        .setText("Бронь столиков")
                        .setActionType("reply")
                        .setBgColor("#2db9b9")
                        .setActionBody("replyTo1"));

                buttons.add(new Button().setColumns(2)
                        .setRows(1)
                        .setText("Карта столов")
                        .setActionType("reply")
                        .setBgColor("#2db9b9")
                        .setActionBody("replyTo1"));

                buttons.add(new Button().setColumns(3)
                        .setRows(1)
                        .setText("Меню")
                        .setActionType("reply")
                        .setBgColor("#2db9b9")
                        .setActionBody("/button_menu"));

                buttons.add(new Button().setColumns(3)
                        .setRows(1)
                        .setText("Акции")
                        .setActionType("reply")
                        .setBgColor("#2db9b9")
                        .setActionBody("replyTo1"));

                keyboard.setButtons(buttons);
                System.out.println("Keyboard : " + keyboard.toString());
                outgoingMessage.setKeyboard(keyboard);

            }
        }
        viberSenderHandler.sendAnswer(outgoingMessage);


    }

    private void ButtonMenuClick() {

        outgoingMessage.setText("Приятного аппетита!");
        outgoingMessage.setType("text");
        outgoingMessage.setReceiver(incomingMessage.getSender().getId());


        Keyboard keyboard = new Keyboard();
        //keyboard.setDefaultHeight(true);

        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(new Button().setColumns(2)
                .setRows(1)
                .setText("Закуски")
                .setActionType("reply")
                .setBgColor("#2db9b9")
                .setActionBody("/button_menu_eat"));

        buttons.add(new Button().setColumns(2)
                .setRows(1)
                .setText("Легкий алкоголь")
                .setActionType("reply")
                .setBgColor("#2db9b9")
                .setActionBody("/button_menu_drinklight"));

        buttons.add(new Button().setColumns(2)
                .setRows(1)
                .setText("Крепкий алкоголь")
                .setActionType("reply")
                .setBgColor("#2db9b9")
                .setActionBody("/button_menu_drinkhard"));

        buttons.add(new Button().setColumns(3)
                .setRows(1)
                .setText("Все меню сразу ")
                .setActionType("reply")
                .setBgColor("#2db9b9")
                .setActionBody("/button_menu_allImg"));

        buttons.add(new Button().setColumns(3)
                .setRows(1)
                .setText("Назад")
                .setActionType("reply")
                .setBgColor("#2db9b9")
                .setActionBody("/main_menu"));

        keyboard.setButtons(buttons);
        outgoingMessage.setKeyboard(keyboard);
    }

    private void ButtonMenu_eatMenu() {
        outgoingMessage.setText("Приятного аппетита!");
        outgoingMessage.setType("picture");
        outgoingMessage.setMedia("https://beerplace.com.ua/wp-content/uploads/2011/09/BarDuck-new-menu-1.jpg");
        outgoingMessage.setReceiver(incomingMessage.getSender().getId());
    }

    private void ButtonMenu_LightDrink() {
        outgoingMessage.setText("ООООО да! Свежего, холодного мне ! ");
        outgoingMessage.setType("picture");
        outgoingMessage.setMedia("https://beerplace.com.ua/wp-content/uploads/2011/09/BarDuck-new-menu-3.jpg");
        outgoingMessage.setReceiver(incomingMessage.getSender().getId());
    }

    private void ButtonMenu_HardDrink() {
        outgoingMessage.setText("Выпьем за любовь!");
        outgoingMessage.setType("picture");
        outgoingMessage.setMedia("https://beerplace.com.ua/wp-content/uploads/2011/09/BarDuck-new-menu-4.jpg");
        outgoingMessage.setReceiver(incomingMessage.getSender().getId());
    }

    private void eventStartConversation() {
        String describe = "Это бот при помощи которого твоя жизнь станет проще ! Выбирай варианты внизу.";
        String name = incomingMessage.getUser().getName();
        name = (name == null) ? "друг" : name;
        String bodyText = "Привет " + name + "!" + "\n" + describe;
        outgoingMessage.setText(bodyText);
        outgoingMessage.setType("text");
        outgoingMessage.setReceiver(incomingMessage.getUser().getId());
        viberSenderHandler.sendAnswer(outgoingMessage);


    }


    @Override
    public String toString() {
        return "MessageHandler{" +
                "outgoingMessage=" + outgoingMessage +
                '}';
    }
}
