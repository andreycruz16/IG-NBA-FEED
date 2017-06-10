package com.markandreydelacruz.ignbafeed.Models;

import java.util.List;

/**
 * Created by mark on 6/3/2017.
 */
public class FeedModel {

    private String id;
    private String code;
    private UserBean user;
    private ImagesBean images;
    private String created_time;
    private CaptionBean caption;
    private LikesBean likes;
    private CommentsBean comments;
    private boolean can_view_comments;
    private boolean can_delete_comments;
    private String type;
    private String link;
    private Object location;
    private String alt_media_url;
    private VideosBean videos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public CaptionBean getCaption() {
        return caption;
    }

    public void setCaption(CaptionBean caption) {
        this.caption = caption;
    }

    public LikesBean getLikes() {
        return likes;
    }

    public void setLikes(LikesBean likes) {
        this.likes = likes;
    }

    public CommentsBean getComments() {
        return comments;
    }

    public void setComments(CommentsBean comments) {
        this.comments = comments;
    }

    public boolean isCan_view_comments() {
        return can_view_comments;
    }

    public void setCan_view_comments(boolean can_view_comments) {
        this.can_view_comments = can_view_comments;
    }

    public boolean isCan_delete_comments() {
        return can_delete_comments;
    }

    public void setCan_delete_comments(boolean can_delete_comments) {
        this.can_delete_comments = can_delete_comments;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public String getAlt_media_url() {
        return alt_media_url;
    }

    public void setAlt_media_url(String alt_media_url) {
        this.alt_media_url = alt_media_url;
    }

    public VideosBean getVideos() {
        return videos;
    }

    public void setVideos(VideosBean videos) {
        this.videos = videos;
    }

    public static class UserBean {
        private String id;
        private String full_name;
        private String profile_picture;
        private String username;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFull_name() {
            return full_name;
        }

        public void setFull_name(String full_name) {
            this.full_name = full_name;
        }

        public String getProfile_picture() {
            return profile_picture;
        }

        public void setProfile_picture(String profile_picture) {
            this.profile_picture = profile_picture;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    public static class ImagesBean {
        private ThumbnailBean thumbnail;
        private LowResolutionBean low_resolution;
        private StandardResolutionBean standard_resolution;

        public ThumbnailBean getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(ThumbnailBean thumbnail) {
            this.thumbnail = thumbnail;
        }

        public LowResolutionBean getLow_resolution() {
            return low_resolution;
        }

        public void setLow_resolution(LowResolutionBean low_resolution) {
            this.low_resolution = low_resolution;
        }

        public StandardResolutionBean getStandard_resolution() {
            return standard_resolution;
        }

        public void setStandard_resolution(StandardResolutionBean standard_resolution) {
            this.standard_resolution = standard_resolution;
        }

        public static class ThumbnailBean {
            private int width;
            private int height;
            private String url;

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class LowResolutionBean {
            private int width;
            private int height;
            private String url;

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class StandardResolutionBean {
            private int width;
            private int height;
            private String url;

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    public static class CaptionBean {
        private String id;
        private String text;
        private String created_time;
        private FromBean from;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getCreated_time() {
            return created_time;
        }

        public void setCreated_time(String created_time) {
            this.created_time = created_time;
        }

        public FromBean getFrom() {
            return from;
        }

        public void setFrom(FromBean from) {
            this.from = from;
        }

        public static class FromBean {
            private String id;
            private String full_name;
            private String profile_picture;
            private String username;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getFull_name() {
                return full_name;
            }

            public void setFull_name(String full_name) {
                this.full_name = full_name;
            }

            public String getProfile_picture() {
                return profile_picture;
            }

            public void setProfile_picture(String profile_picture) {
                this.profile_picture = profile_picture;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }
    }

    public static class LikesBean {
        private int count;
        private List<DataBean> data;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            private String id;
            private String full_name;
            private String profile_picture;
            private String username;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getFull_name() {
                return full_name;
            }

            public void setFull_name(String full_name) {
                this.full_name = full_name;
            }

            public String getProfile_picture() {
                return profile_picture;
            }

            public void setProfile_picture(String profile_picture) {
                this.profile_picture = profile_picture;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }
    }

    public static class CommentsBean {
        private int count;
        private List<DataBeanX> data;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<DataBeanX> getData() {
            return data;
        }

        public void setData(List<DataBeanX> data) {
            this.data = data;
        }

        public static class DataBeanX {
            private String id;
            private String text;
            private String created_time;
            private FromBeanX from;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getCreated_time() {
                return created_time;
            }

            public void setCreated_time(String created_time) {
                this.created_time = created_time;
            }

            public FromBeanX getFrom() {
                return from;
            }

            public void setFrom(FromBeanX from) {
                this.from = from;
            }

            public static class FromBeanX {
                private String id;
                private String full_name;
                private String profile_picture;
                private String username;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getFull_name() {
                    return full_name;
                }

                public void setFull_name(String full_name) {
                    this.full_name = full_name;
                }

                public String getProfile_picture() {
                    return profile_picture;
                }

                public void setProfile_picture(String profile_picture) {
                    this.profile_picture = profile_picture;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }
            }
        }
    }

    public static class VideosBean {
        private StandardResolutionBeanX standard_resolution;
        private LowBandwidthBean low_bandwidth;
        private LowResolutionBeanX low_resolution;

        public StandardResolutionBeanX getStandard_resolution() {
            return standard_resolution;
        }

        public void setStandard_resolution(StandardResolutionBeanX standard_resolution) {
            this.standard_resolution = standard_resolution;
        }

        public LowBandwidthBean getLow_bandwidth() {
            return low_bandwidth;
        }

        public void setLow_bandwidth(LowBandwidthBean low_bandwidth) {
            this.low_bandwidth = low_bandwidth;
        }

        public LowResolutionBeanX getLow_resolution() {
            return low_resolution;
        }

        public void setLow_resolution(LowResolutionBeanX low_resolution) {
            this.low_resolution = low_resolution;
        }

        public static class StandardResolutionBeanX {
            private int width;
            private int height;
            private String url;

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class LowBandwidthBean {
            private int width;
            private int height;
            private String url;

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class LowResolutionBeanX {
            private int width;
            private int height;
            private String url;

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
