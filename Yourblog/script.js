// --- Authentication ---
function register() {
  let username = document.getElementById("username").value;
  let password = document.getElementById("password").value;

  if (localStorage.getItem(username)) {
    alert("User already exists!");
  } else {
    localStorage.setItem(username, password);
    alert("Registered successfully!");
  }
}

function login() {
  let username = document.getElementById("username").value;
  let password = document.getElementById("password").value;

  if (localStorage.getItem(username) === password) {
    localStorage.setItem("loggedInUser", username);
    window.location.href = "index.html";
  } else {
    alert("Invalid login!");
  }
}

function logout() {
  localStorage.removeItem("loggedInUser");
  window.location.href = "login.html";
}

// --- Blog CRUD ---
function saveBlog() {
  let user = localStorage.getItem("loggedInUser");
  if (!user) { alert("Login first!"); return; }

  let title = document.getElementById("title").value;
  let content = document.getElementById("content").value;

  let blogs = JSON.parse(localStorage.getItem("blogs")) || [];
  blogs.push({ user, title, content });
  localStorage.setItem("blogs", JSON.stringify(blogs));

  window.location.href = "index.html";
}

function loadBlogs() {
  let blogs = JSON.parse(localStorage.getItem("blogs")) || [];
  let container = document.getElementById("blog-list");
  if (!container) return;

  container.innerHTML = "";
  blogs.forEach((blog, index) => {
    let div = document.createElement("div");
    div.innerHTML = `<h3>${blog.title}</h3><p>${blog.content}</p><small>By: ${blog.user}</small>`;
    
    // Allow edit/delete only for owner
    if (localStorage.getItem("loggedInUser") === blog.user) {
      div.innerHTML += `
        <button onclick="deleteBlog(${index})">Delete</button>
      `;
    }
    container.appendChild(div);
  });
}

function deleteBlog(index) {
  let blogs = JSON.parse(localStorage.getItem("blogs")) || [];
  blogs.splice(index, 1);
  localStorage.setItem("blogs", JSON.stringify(blogs));
  loadBlogs();
}

// Load blogs if on index.html
window.onload = loadBlogs;
