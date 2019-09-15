package com.company.configuration;

import com.company.service.TextHandleService;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Scanner;


public class BotConfig extends TelegramLongPollingBot {
    private static final String TOKEN = "888768127:AAHsWj1vCQPvQS6uTTQY2w5oChvgEPj-spI";
    private static final String BOT_NAME = "UniversityDepartmentsBot";
    private static String CHATID;

    public void onUpdateReceived(Update update) {
        String userText = update.getMessage().getText();
        CHATID = update.getMessage().getChatId().toString();
        userText = userText.trim();
        TextHandleService textHandleService = new TextHandleService();
        sendMessage(textHandleService.messageManager(userText));

    }

    private void forConsole() { //if you want to use console
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        TextHandleService textHandleService = new TextHandleService();
        System.out.println(textHandleService.messageManager(text));
    }

    public void sendMessage(String text) {
        SendMessage sendmessage = (new SendMessage()).setChatId(CHATID).setText(text);

        try {
            this.execute(sendmessage);
        } catch (TelegramApiException var5) {
            var5.printStackTrace();
        }
    }


    public String getBotUsername() {
        return BOT_NAME;
    }

    public String getBotToken() {
        return TOKEN;
    }
}
