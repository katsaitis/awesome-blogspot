$(function () {

    getPosts();

    const pathname = window.location.pathname;
    // getPostData();
    // lord have mercy on me for this hack.
    const urlData = pathname.split('/');
    console.log(urlData);
    if (urlData.length > 2 && urlData[1] === 'posts') {
        getPostData(urlData[3]).then((post) => {
            console.log(post)
            let html = '<div class="card"><h2 id="title2"><a href="/posts/post/' + post.id + '">' + post.title
                + '</a></h2><p id="timestamp"><a id="author"></a></p>';
            html += '<p id="timestamp">' + post.createdAt + '</p><p id="text">' + post.body + '</p></div>';
            $('#showPost').append(html);
        })
    }

    checkIfAuthenticated().then((isAuth) => {
        if (isAuth) {
            //change login button to "admin button"
            $('#log').html('Admin').attr('href', 'admin/index')
        }
    });

    $("#postButton").click(function () {

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

function getPosts() {
    $.ajax({
        method: 'GET',
        url: '/posts/',
        success: (data) => {
            data.forEach((post) => {
                let html = '<div class="card"><h2 id="title2"><a href="/posts/post/' + post.id + '">' + post.title + '</a></h2><p id="timestamp"><a id="author"></a></p>';
                html += '<p id="timestamp">' + post.createdAt + '</p><p id="text">' + post.body + '</p></div>';
                $('#lc').append(html);
            })
        }
    })
}

function getPostData(postId) {
    return $.ajax({
        method: 'GET',
        url: '/posts/post/' + postId + '/data'
    })
}