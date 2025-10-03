# 📝 YourBlog - Blog Platform (Frontend-Only)

A simple blog platform built with **HTML, CSS, and JavaScript** without any backend.  
All user data (login details and blogs) are stored in **localStorage**, so the app works completely in the browser.  

---

##  Features
-  **User Authentication** (Register & Login using localStorage)  
-  **Create Blogs** with title and content  
-  **View Blogs** in a clean card layout  
-  **Delete Blogs** (only by the owner)  
-  Data persistence using **localStorage**  

---

## 📂 Project Structure

yourblog
|
|_____index.html
|_____style.css
|_____create.html
|_____login.html
|_____script.js

##  How It Works
1. Open `login.html` in your browser.  
2. Register with a new username and password (stored in `localStorage`).  
3. Login → redirects to `index.html` (Home).  
4. Add a new blog via `create.html`.  
5. Blogs appear on the home page and are saved in `localStorage`.  
6. Only the blog owner can delete their posts.  
