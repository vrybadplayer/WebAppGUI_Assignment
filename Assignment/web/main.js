const courseLink = document.querySelector('.courseLink');
const dropdown = document.querySelector('.dropdown');

let timeout;

// Show the dropdown when the mouse is over the link
courseLink.addEventListener('mouseover', () => {
  clearTimeout(timeout); // Clear any existing timeout
  dropdown.style.display = 'flex';
});

// Hide the dropdown after a short delay when the mouse leaves the link and the dropdown
courseLink.addEventListener('mouseout', () => {
  timeout = setTimeout(() => {
    dropdown.style.display = 'none';
  }, 200); // Adjust the delay as needed (200ms in this example)
});

// Keep the dropdown visible when the mouse is over the dropdown itself
dropdown.addEventListener('mouseover', () => {
  clearTimeout(timeout); // Clear any existing timeout
  dropdown.style.display = 'flex';
});

// Hide the dropdown after a short delay when the mouse leaves the dropdown
dropdown.addEventListener('mouseout', () => {
  timeout = setTimeout(() => {
    dropdown.style.display = 'none';
  }, 200); // Adjust the delay as needed (200ms in this example)
});

