$(document).ready(function() {

  $('.carousel').carousel({duration: 200});

  $('.modal').modal();
  $('ul.tabs').tabs();

  setInterval(function() {
    $('.carousel').carousel('next');
  }, 2000); // every 2 seconds
  
});


