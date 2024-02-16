/*!
* Start Bootstrap - Shop Homepage v5.0.6 (https://startbootstrap.com/template/shop-homepage)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-shop-homepage/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project

// scripts.js

// 홈페이지에서 앞 첫 번째 페이지 부분만 보여주는 기능 구현.
document.addEventListener('DOMContentLoaded', function () {
    // Function to initialize the PDF viewer with a given URL
    function initializePdfViewer(pdfUrl) {
        // Initialize the PDF viewer
        var viewer = new Viewer(document.getElementById('pdf-viewer'), {
            inline: true,
            navbar: false,
            toolbar: false,
            title: false,
            url: pdfUrl,
        });

        // Set the initial page range to show only the first page
        viewer.setPage(1);
    }

    // Get all elements with the class 'pdf-image'
    var pdfImageElements = document.querySelectorAll('.pdf-image');

    // Loop through each 'pdf-image' element and initialize the viewer
    pdfImageElements.forEach(function (element) {
        var pdfUrl = element.getAttribute('data-pdf-url');
        initializePdfViewer(pdfUrl);
    });
});


