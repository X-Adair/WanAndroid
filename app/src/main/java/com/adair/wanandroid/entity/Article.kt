package com.adair.wanandroid.entity

/**
 *
 *
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/8/17
 */


/*{
                "apkLink":"",
                "audit":1,
                "author":"",
                "canEdit":false,
                "chapterId":502,
                "chapterName":"自助",
                "collect":false,
                "courseId":13,
                "desc":"",
                "descMd":"",
                "envelopePic":"",
                "fresh":false,
                "id":14737,
                "link":"https://juejin.im/post/6844903588330733576",
                "niceDate":"2020-08-12 09:21",
                "niceShareDate":"2020-08-12 09:21",
                "origin":"",
                "prefix":"",
                "projectLink":"",
                "publishTime":1597195309000,
                "realSuperChapterId":493,
                "selfVisible":0,
                "shareDate":1597195309000,
                "shareUser":"躬行之",
                "superChapterId":494,
                "superChapterName":"广场Tab",
                "tags":[

                ],
                "title":"Android进阶AIDL使用自定义类型",
                "type":0,
                "userId":23270,
                "visible":1,
                "zan":0
            }
            */
data class Article(
    var apkLink: String,
    var audit: Int,
    var author: String,
    var canEdit: Boolean,
    var chapterId: Long,
    var chapterName: String,
    var collect: Boolean,
    var courseId: Long,
    var desc: String,
    var descMd: String,
    var envelopePic: String,
    var fresh: Boolean,
    var id: Long,
    var link: String,
    var niceDate: String,
    var niceShareDate: String,
    var origin: String,
    var prefix: String,
    var projectLink: String,
    var publishTime: Long,
    var realSuperChapterId: Long,
    var selfVisible: Int,
    var shareDate: Long,
    var shareUser: String,
    var superChapterId: Long,
    var superChapterName: String,
    var tags: List<String>,
    var title: String,
    var type: Int,
    var userId: Long,
    var visible: Int,
    var zan: Int
)