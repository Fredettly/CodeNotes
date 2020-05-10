function post() {
    var blogId = $("#blog_id").val();
    var content = $("#comment_content").val();
    console.log(blogId);
    console.log(content);
    comment2target(blogId, content);
}

function comment2target(targetId, content) {

    if (!content) {
        alert("回复的内容不能为空哦！");
        return;
    }

    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: 'application/json',
        data: JSON.stringify({
            "parentId": targetId,
            "content": content
        }),
        success: function (response) {
            if (response.code == 200) {
                window.location.reload();
            } else {
                alert(response.message);
            }
            console.log(response);
        },
        dataType: "json"
    });

}

$(function () {
    editormd.markdownToHTML("blog-content", {
        emoji: true,
        path: "./editormd/lib/",
        previewTheme: "tomorrow-night-eighties"
    });
});

$('.lists').click(function () {
    $('.m-item').toggleClass('m-mobile-hide');
});

$('#paybutton').popup({
    popup: $('.payQ.popup'),
    on: 'click'
});