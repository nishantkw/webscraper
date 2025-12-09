package com.WebScrapping.Service;

import com.WebScrapping.model.ScrapeResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScraperService {

    public ScrapeResponse webScrape(String url) throws IOException {

        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0")
                .timeout(10000)
                .get();

        List<String> images = new ArrayList<>();
        List<String> videos = new ArrayList<>();
        List<String> links = new ArrayList<>();

        // Extract images
        for (Element img : doc.select("img")) {
            String src = img.absUrl("src");
            if (!src.isEmpty()) images.add(src);
        }

        // Extract HTML5 <video> and <source>
        for (Element video : doc.select("video, video source")) {
            String src = video.absUrl("src");
            if (!src.isEmpty()) videos.add(src);
        }

        // Extract iframe embedded videos (YouTube, Vimeo)
        for (Element iframe : doc.select("iframe")) {
            String src = iframe.absUrl("src");
            if (src.contains("youtube") || src.contains("vimeo") || src.contains("player")) {
                videos.add(src);
            }
        }

        // Extract hyperlinks
        for (Element link : doc.select("a[href]")) {
            String href = link.absUrl("href");
            if (!href.isEmpty()) links.add(href);
        }

        // Send response
        ScrapeResponse response = new ScrapeResponse();
        response.setImages(images);
        response.setVideos(videos);
        response.setLinks(links);

        return response;
    }
}
