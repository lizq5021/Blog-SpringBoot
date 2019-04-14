var music_json = [];
$.ajax({
    type: "get",
    async: false,
    url: "music/fandAll",
    dataType: "json",
    success: function (data) {
        if (data.flag == true) {
            $.each(data.data, function (index, music) {
                var temp_json = {};
                temp_json.title = music.mTitle;
                temp_json.author = music.mAuthor;
                temp_json.url = music.mUrl;
                temp_json.pic = music.mPic;
                temp_json.lrc = music.mLrc;
                music_json.push(temp_json);
            });
        }
    }
});
