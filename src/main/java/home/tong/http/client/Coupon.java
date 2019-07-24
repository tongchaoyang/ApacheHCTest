package home.tong.http.client;

import java.io.Serializable;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coupon implements Serializable {
    private static final long serialVersionUID = 123325148887688122L;

    @JsonProperty("short_description")
    private String shortDescription;
    @JsonProperty("requirement_upcs")
    private String[] requirementUpcs;
    private String featured;
    @JsonProperty("pos_live_date")
    private String posLiveDate;
    @JsonProperty("external_id")
    private String externalId;
    @JsonProperty("expiration_date")
    private String expirationDate;
    private String enabled;
    @JsonProperty("total_downloads")
    private String totalDownloads;
    @JsonProperty("publication_id")
    private String publicationId;
    @JsonProperty("coupon_id")
    private String couponId;
    @JsonProperty("reward_upcs")
    private String[] rewardUpcs;
    @JsonProperty("display_end_date")
    private String displayEndDate;
    private String savings;
    private String value;
    @JsonProperty("offer_type")
    private String offerType;
    @JsonProperty("targeted_offer")
    private String targetedOffer;
    @JsonProperty("offer_priority")
    private String offerPriority;
    @JsonProperty("display_start_date")
    private String displayStartDate;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("brand_name")
    private String brandName;
    @JsonProperty("long_description")
    private String longDescription;
    @JsonProperty("requirement_description")
    private String requirementDescription;
    private Tag[] tags;
    @JsonProperty("long_description_header")
    private String longDescriptionHeader;
    @JsonProperty("targeting_buckets")
    private Object[] targetingBuckets;
    private String category;
    private String subcategory;
    
    public Coupon() {
        super();
    }

    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    public String[] getRequirementUpcs() {
        return requirementUpcs;
    }
    public void setRequirementUpcs(String[] requirementUpcs) {
        this.requirementUpcs = requirementUpcs;
    }
    public String getFeatured() {
        return featured;
    }
    public void setFeatured(String featured) {
        this.featured = featured;
    }
    public String getPosLiveDate() {
        return posLiveDate;
    }
    public void setPosLiveDate(String posLiveDate) {
        this.posLiveDate = posLiveDate;
    }
    public String getExternalId() {
        return externalId;
    }
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }
    public String getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    public String getEnabled() {
        return enabled;
    }
    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
    public String getTotalDownloads() {
        return totalDownloads;
    }
    public void setTotalDownloads(String totalDownloads) {
        this.totalDownloads = totalDownloads;
    }
    public String getPublicationId() {
        return publicationId;
    }
    public void setPublicationId(String publicationId) {
        this.publicationId = publicationId;
    }
    public String getCouponId() {
        return couponId;
    }
    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }
    public String[] getRewardUpcs() {
        return rewardUpcs;
    }
    public void setRewardUpcs(String[] rewardUpcs) {
        this.rewardUpcs = rewardUpcs;
    }
    public String getDisplayEndDate() {
        return displayEndDate;
    }
    public void setDisplayEndDate(String displayEndDate) {
        this.displayEndDate = displayEndDate;
    }
    public String getSavings() {
        return savings;
    }
    public void setSavings(String savings) {
        this.savings = savings;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getOfferType() {
        return offerType;
    }
    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }
    public String getTargetedOffer() {
        return targetedOffer;
    }
    public void setTargetedOffer(String targetedOffer) {
        this.targetedOffer = targetedOffer;
    }
    public String getOfferPriority() {
        return offerPriority;
    }
    public void setOfferPriority(String offerPriority) {
        this.offerPriority = offerPriority;
    }
    public String getDisplayStartDate() {
        return displayStartDate;
    }
    public void setDisplayStartDate(String displayStartDate) {
        this.displayStartDate = displayStartDate;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public String getLongDescription() {
        return longDescription;
    }
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
    public String getRequirementDescription() {
        return requirementDescription;
    }
    public void setRequirementDescription(String requirementDescription) {
        this.requirementDescription = requirementDescription;
    }
    public Tag[] getTags() {
        return tags;
    }
    public void setTags(Tag[] tags) {
        this.tags = tags;
    }
    public String getLongDescriptionHeader() {
        return longDescriptionHeader;
    }
    public void setLongDescriptionHeader(String longDescriptionHeader) {
        this.longDescriptionHeader = longDescriptionHeader;
    }
    public Object[] getTargetingBuckets() {
        return targetingBuckets;
    }
    public void setTargetingBuckets(Object[] targetingBuckets) {
        this.targetingBuckets = targetingBuckets;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getSubcategory() {
        return subcategory;
    }
    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    @Override
    public String toString() {
        return "Coupon [shortDescription=" + shortDescription + ", requirementUpcs=" + Arrays.toString(requirementUpcs)
                + ", featured=" + featured + ", posLiveDate=" + posLiveDate + ", externalId=" + externalId
                + ", expirationDate=" + expirationDate + ", enabled=" + enabled + ", totalDownloads=" + totalDownloads
                + ", publicationId=" + publicationId + ", couponId=" + couponId + ", rewardUpcs="
                + Arrays.toString(rewardUpcs) + ", displayEndDate=" + displayEndDate + ", savings=" + savings
                + ", value=" + value + ", offerType=" + offerType + ", targetedOffer=" + targetedOffer
                + ", offerPriority=" + offerPriority + ", displayStartDate=" + displayStartDate + ", imageUrl="
                + imageUrl + ", brandName=" + brandName + ", longDescription=" + longDescription
                + ", requirementDescription=" + requirementDescription + ", tags=" + Arrays.toString(tags)
                + ", longDescriptionHeader=" + longDescriptionHeader + ", targetingBuckets=" + targetingBuckets
                + ", category=" + category + ", subcategory=" + subcategory + "]";
    }
}
