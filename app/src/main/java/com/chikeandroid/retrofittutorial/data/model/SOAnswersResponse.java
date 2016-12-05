package com.chikeandroid.retrofittutorial.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Chike on 12/4/2016.
 */

public class SOAnswersResponse {

    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("has_more")
    @Expose
    private Boolean hasMore;
    @SerializedName("backoff")
    @Expose
    private Integer backoff;
    @SerializedName("quota_max")
    @Expose
    private Integer quotaMax;
    @SerializedName("quota_remaining")
    @Expose
    private Integer quotaRemaining;

    /**
     *
     * @return
     * The items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     *
     * @param items
     * The items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     *
     * @return
     * The hasMore
     */
    public Boolean getHasMore() {
        return hasMore;
    }

    /**
     *
     * @param hasMore
     * The has_more
     */
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    /**
     *
     * @return
     * The backoff
     */
    public Integer getBackoff() {
        return backoff;
    }

    /**
     *
     * @param backoff
     * The backoff
     */
    public void setBackoff(Integer backoff) {
        this.backoff = backoff;
    }

    /**
     *
     * @return
     * The quotaMax
     */
    public Integer getQuotaMax() {
        return quotaMax;
    }

    /**
     *
     * @param quotaMax
     * The quota_max
     */
    public void setQuotaMax(Integer quotaMax) {
        this.quotaMax = quotaMax;
    }

    /**
     *
     * @return
     * The quotaRemaining
     */
    public Integer getQuotaRemaining() {
        return quotaRemaining;
    }

    /**
     *
     * @param quotaRemaining
     * The quota_remaining
     */
    public void setQuotaRemaining(Integer quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }
}
