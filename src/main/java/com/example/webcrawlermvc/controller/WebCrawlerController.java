package com.example.webcrawlermvc.controller;

import com.example.webcrawlermvc.model.Website;
import com.example.webcrawlermvc.model.WebsiteGlobal;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawlerController {
    @FXML
    private TextField textFieldWebsite;
    @FXML
    private TextArea textAreaResults;
    @FXML
    private Text textTitle;
    private WebsiteGlobal websiteGlobal;
    private static Queue<String> list_of_websites = new LinkedList<>();
    private static Set<String> marked = new HashSet<>();
    private static String regex = "http[s]*://(\\w+\\.)*(\\w+)";
    private String results;

    @FXML
    protected void onButtonCleanClick(){
        textAreaResults.clear();
        textFieldWebsite.clear();
        results = "";
    }

    @FXML
    protected void onButtonExecuteClick() throws IOException{
        textAreaResults.clear();
        textTitle.setText("Results");
        textTitle.isVisible();
        Website website = new Website();
        if (textFieldWebsite.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid website");
            alert.showAndWait();
        }
        website.setParentSite(textFieldWebsite.getText());
        list_of_websites = websiteGlobal.get_list_websites(website.getParentSite());

        while (!list_of_websites.isEmpty()){
            String crawledUrl = list_of_websites.poll();
            textAreaResults.setText(textAreaResults.getText() + "\n\n====== Site crawled: " + crawledUrl + " =====\n");
            System.out.println("\n====== Site crawled: " + crawledUrl + " =====");

            boolean ok = false;
            URL url;
            BufferedReader br = null;

            while (!ok){
                try{
                    url = new URL(crawledUrl);
                    br = new BufferedReader((new InputStreamReader(url.openStream())));
                    ok = true;
                }catch (MalformedURLException e){
                    System.out.println("Malformed URL: " + crawledUrl);
                    crawledUrl = list_of_websites.poll();
                }catch (IOException e){
                    System.out.println("IOException fro URL: " + crawledUrl);
                    crawledUrl = list_of_websites.poll();
                }
            }

            StringBuilder sb = new StringBuilder();

            while((crawledUrl = br.readLine()) != null){
                sb.append(crawledUrl);
            }

            crawledUrl = sb.toString();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(crawledUrl);

            while (matcher.find()){
                String w = matcher.group();
                if (marked.size() >= 100)
                    break;
                if (!marked.add(w)){
                    marked.add(w);
                    results = results + "Site added for crawling: " + w + "\n";
                    System.out.println("Site added for crawling: " + w);
                }
            }
            textAreaResults.setText(textAreaResults.getText() + results);
        }
    }
}