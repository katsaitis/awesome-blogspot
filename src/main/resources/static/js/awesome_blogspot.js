$(function () {

  checkIfAuthenticated().then((isAuth)=> {
    if (isAuth){
      //change login button to "admin button"
      $('#log').html('Admin').attr('href', 'admin/index')
    }
  });

  $("#postButton").click(function () {

  });

  $("#deleteButton").click(function () {

  });

  $("#editButton").click(function () {

  });

  $("#repostButton").click(function () {

  });

});

function checkIfAuthenticated() {
  return $.ajax({
    method: 'GET',
    url: '/isAuthenticated',
    success: function (res) {
      return res;
    }
  })
}