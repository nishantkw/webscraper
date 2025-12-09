# 🌐 Web Scraping Tool – Images, Videos & Links Extractor

A modern and fast **Spring Boot Web Scraper** that extracts **Images**, **Videos**, and **Hyperlinks** from any public website.  
Just provide a URL → get clean JSON containing all media from the page.

---

## 🔥 Features

- 🖼 Extract **all images** from any webpage  
- 🎥 Extract **video URLs** (direct links, MP4, embedded sources)  
- 🔗 Extract **all links** including internal + external  
- ⚡ Super fast scraping using **Jsoup**  
- 🧹 Clean JSON response model  
- 📡 REST API ready for frontend integration  
- 🚀 Deployable on **Render / Railway / AWS / Netlify Backend**  

---

## 🛠️ Tech Stack

| Component | Technology |
|-----------|------------|
| Backend | Spring Boot |
| Language | Java |
| HTML Scraping | Jsoup |
| Build Tool | Maven |
| Deployment | Render |
| Format | JSON |

---

## 📁 Project Structure

src
└── main
└── java/com/WebScrapping/
├── controller/
│ └── ScrapeController.java
├── service/
│ └── ScraperService.java
├── model/
│ └── ScrapeResponse.java
└── WebScrappingApplication.java
