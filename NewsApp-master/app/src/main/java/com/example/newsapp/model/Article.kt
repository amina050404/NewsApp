package com.example.newsapp.model

data class Article(
    var author: String? = null, // Devindra Hardawar
    var content: String? = null, // Tesla is receiving minimal blame for a fiery 2018 crash in South Florida, which killed two teenagers and injured another. A jury today found Tesla just one percent responsible for the crash, reports … [+1155 chars]
    var description: String? = null, // Tesla is receiving minimal blame for a fiery 2018 crash in South Florida, which killed two teenagers and injured another. A jury today found Tesla just one percent responsible for the crash, reports the AP, which means it's only responsible for paying $105,00…
    var publishedAt: String? = null, // 2022-07-20T21:05:10Z
    var source: Source? = null,
    var title: String? = null, // Jury finds Tesla just '1%' responsible for a Florida teen's crash
    var url: String? = null, // https://www.engadget.com/tesla-jury-trial-crash-miami-210510480.html
    var urlToImage: String? = null // https://s.yimg.com/os/creatr-uploaded-images/2020-09/58f2dbb0-fdcf-11ea-87ad-36f873b9d898
)