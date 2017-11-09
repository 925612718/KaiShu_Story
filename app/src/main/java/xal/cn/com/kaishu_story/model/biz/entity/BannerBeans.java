package xal.cn.com.kaishu_story.model.biz.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 * 作者:刘鑫
 */

public class BannerBeans {

    /**
     * errcode : 0
     * result : {"list":[{"adid":"713","allowClick":1,"allowClose":0,"clientType":"all","disposable":0,"endTime":1509465540000,"imgurl":"https://cdn.kaishuhezi.com/kstory/story/image/487f632f-65ee-4e42-bc53-b661f9dbcd36.jpg","isBeta":0,"isDefault":0,"line":0,"link":"1190","pageType":"1","param":{},"params":"1190","startTime":1509379140000,"title":"凯叔讲历史-怎么忽悠楚霸王","type":"product_yearpackage"},{"adid":"683","allowClick":1,"allowClose":0,"clientType":"all","disposable":0,"endTime":1509465540000,"imgurl":"https://cdn.kaishuhezi.com/kstory/story/image/aa19c5eb-2926-4e46-a40c-1eee85ef8c40.gif","isBeta":0,"isDefault":0,"line":0,"link":"1218","pageType":"1","param":{},"params":"1218","startTime":1509292740000,"title":"科学真好玩-凶猛的中国龙","type":"product_yearpackage"},{"adid":"747","allowClick":1,"allowClose":0,"clientType":"all","disposable":0,"endTime":1509379140000,"imgurl":"https://cdn.kaishuhezi.com/kstory/story/image/4250619d-0b05-44fe-8423-82a14dc053cf.jpg","isBeta":0,"isDefault":0,"line":0,"link":"1270","pageType":"1","param":{},"params":"1270","startTime":1509119940000,"title":"纳尼亚传奇（第二部）","type":"product_ablum"},{"adid":"752","allowClick":1,"allowClose":0,"clientType":"all","disposable":0,"endTime":1509551940000,"imgurl":"https://cdn.kaishuhezi.com/kstory/story/image/6565ae15-d679-4616-86fe-04d61564a243.jpg","isBeta":0,"isDefault":0,"line":0,"link":"104980","pageType":"1","param":{},"params":"104980","startTime":1509292740000,"title":"万圣节活动","type":"story"},{"adid":"740","allowClick":1,"allowClose":0,"clientType":"all","disposable":0,"endTime":1514703540000,"imgurl":"https://cdn.kaishuhezi.com/kstory/banner/image/6e09b6f9-5272-4166-9532-193604553c65.jpg","isBeta":0,"isDefault":0,"line":0,"link":"https://kdt.im/NUMPoh","pageType":"1","param":{},"params":"https://kdt.im/NUMPoh","startTime":1508914740000,"title":"电商-小诗仙（新包装）","type":"youzan_web"},{"adid":"561","allowClick":1,"allowClose":0,"clientType":"all","disposable":0,"endTime":1509465540000,"imgurl":"https://cdn.kaishuhezi.com/kstory/story/image/05cd1019-4b39-4890-be30-c6ce982c9a62.jpg","isBeta":0,"isDefault":0,"line":0,"link":"344","pageType":"1","param":{},"params":"344","startTime":1509292740000,"title":"6岁+精选故事(第六期)","type":"ablum"}]}
     */

    private int errcode;
    private ResultBean result;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * adid : 713
             * allowClick : 1
             * allowClose : 0
             * clientType : all
             * disposable : 0
             * endTime : 1509465540000
             * imgurl : https://cdn.kaishuhezi.com/kstory/story/image/487f632f-65ee-4e42-bc53-b661f9dbcd36.jpg
             * isBeta : 0
             * isDefault : 0
             * line : 0
             * link : 1190
             * pageType : 1
             * param : {}
             * params : 1190
             * startTime : 1509379140000
             * title : 凯叔讲历史-怎么忽悠楚霸王
             * type : product_yearpackage
             */

            private String adid;
            private int allowClick;
            private int allowClose;
            private String clientType;
            private int disposable;
            private long endTime;
            private String imgurl;
            private int isBeta;
            private int isDefault;
            private int line;
            private String link;
            private String pageType;
            private ParamBean param;
            private String params;
            private long startTime;
            private String title;
            private String type;

            public String getAdid() {
                return adid;
            }

            public void setAdid(String adid) {
                this.adid = adid;
            }

            public int getAllowClick() {
                return allowClick;
            }

            public void setAllowClick(int allowClick) {
                this.allowClick = allowClick;
            }

            public int getAllowClose() {
                return allowClose;
            }

            public void setAllowClose(int allowClose) {
                this.allowClose = allowClose;
            }

            public String getClientType() {
                return clientType;
            }

            public void setClientType(String clientType) {
                this.clientType = clientType;
            }

            public int getDisposable() {
                return disposable;
            }

            public void setDisposable(int disposable) {
                this.disposable = disposable;
            }

            public long getEndTime() {
                return endTime;
            }

            public void setEndTime(long endTime) {
                this.endTime = endTime;
            }

            public String getImgurl() {
                return imgurl;
            }

            public void setImgurl(String imgurl) {
                this.imgurl = imgurl;
            }

            public int getIsBeta() {
                return isBeta;
            }

            public void setIsBeta(int isBeta) {
                this.isBeta = isBeta;
            }

            public int getIsDefault() {
                return isDefault;
            }

            public void setIsDefault(int isDefault) {
                this.isDefault = isDefault;
            }

            public int getLine() {
                return line;
            }

            public void setLine(int line) {
                this.line = line;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getPageType() {
                return pageType;
            }

            public void setPageType(String pageType) {
                this.pageType = pageType;
            }

            public ParamBean getParam() {
                return param;
            }

            public void setParam(ParamBean param) {
                this.param = param;
            }

            public String getParams() {
                return params;
            }

            public void setParams(String params) {
                this.params = params;
            }

            public long getStartTime() {
                return startTime;
            }

            public void setStartTime(long startTime) {
                this.startTime = startTime;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public static class ParamBean {
            }
        }
    }
}
