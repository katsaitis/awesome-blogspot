$(function () {

    getPosts();

    const pathname = window.location.pathname;

    // lord have mercy on me for this hack.
    const urlData = pathname.split('/');
    if (urlData.length > 2 && urlData[1] === 'posts') {
        getPostData(urlData[3]).then((post) => {
            let html = '<div class="card"><h2 id="title2"><a href="/posts/post/' + post.id + '">' + post.title
                + '</a></h2><p id="timestamp"><a id="author"></a></p>';
            html += '<p id="timestamp">' + post.createdAt + '</p><p id="text">' + post.body + '</p></div>';
            $('#showPost').prepend(html);
        }).then(getPostComments(urlData[3]))
    }

    checkIfAuthenticated().then((isAuth) => {
        if (isAuth) {
            //change login button to "admin button"
            $('#log').html('Admin').attr('href', 'admin/index')
        }
    });

    $('#communicationButton').click((event) => {
        submitComment();
    })
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
                let html = '<div class="card"><h2 id="title2"><a href="/posts/post/' + post.id + '">' + post.title + '</a></h2><a id="author"></a>';
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

function getPostCommentData(postId) {
    return $.ajax({
        method: 'GET',
        url: '/comments/' + postId
    })
}


function getPostComments(postId) {
    getPostCommentData(postId).then((comments) => {
        comments.forEach((comment) => {
            let html = '<div class="card"><h4 id="title3">' + comment.body + '</h4><p id="timestamp">' + comment.createdAt + ' by Anonymous user</p></div>';
            $('#comments').append(html)
        })

    })
}

function submitComment() {
    event.preventDefault();
    let comment = '';
    for (const entry of $('form').serializeArray()) {
        if (entry.name === 'title') {
            comment += ' wrote: '
        }
        comment += entry.value + ' ';
    }
    // if the last part of the url path is a number then send back as a comment for a specific post
    const pathname = window.location.pathname;
    const number = parseInt(pathname.split('/')[pathname.split('/').length - 1]);
    let payload = {};
    if (!isNaN(number)) {
        payload.id = number;
    }
    payload.title = comment;

    $.ajax({
        url: '/comments/comment',
        method: 'POST',
        data: JSON.stringify(payload),
        contentType: 'application/json',
        success: () => {
            location.reload();
        }
    });
}