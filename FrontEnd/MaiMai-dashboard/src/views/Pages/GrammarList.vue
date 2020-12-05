<template>
  <div>
    <div
      class="header pb-8 pt-5 pt-lg-8 d-flex align-items-center profile-header"
      style="
        min-height: 600px;
        background-image: url(img/theme/profile-cover.jpg);
        background-size: cover;
        background-position: center top;
      "
    >
      <b-container fluid>
        <!-- Mask -->
        <span class="mask bg-gradient-success opacity-8"></span>
        <!-- Header container -->
        <b-container fluid class="d-flex align-items-center">
          <b-row> </b-row>
        </b-container>
      </b-container>
    </div>

    <b-container fluid class="mt--6">
      <div class="row">
        <div class="col-3 border border-secondary shadow p-2 mb-6 rounded">
          <div
            v-for="item in data"
            :key="item.id"
            class="border border-secondary shadow p-1 mb-1 rounded link"
          >
            <a
              href="javascript:void(0)"
              class="href-style text-left"
              @click="clickContent(item)"
            >
              {{ item.grammarContent }}
            </a>
          </div>
        </div>
        <div class="col border border-secondary shadow p-2 mb-6 rounded">
          <div v-if="isDisplay" class="col">
            <label
              class="col-4 col-form-label col-form-label-sm text-secondary font-weight-bold d-flex align-items-left justify-content-left"
            >
              Ngữ pháp
            </label>
            <div>{{ grItem.grammarContent }}</div>
            <hr />
            <label
              class="col-4 col-form-label col-form-label-sm text-secondary font-weight-bold d-flex align-items-left justify-content-left"
            >
              Nghĩa
            </label>
            <div>{{ grItem.meanVi }}</div>
            <hr />
            <label
              class="col-4 col-form-label col-form-label-sm text-secondary font-weight-bold d-flex align-items-left justify-content-left"
            >
              Ý Nghĩa Chức Năng
            </label>
            <div>{{ grItem.meanFunction }}</div>
            <hr />
            <label
              class="col-4 col-form-label col-form-label-sm text-secondary font-weight-bold d-flex align-items-left justify-content-left"
            >
              Cách dùng
            </label>
            <div>{{ grItem.wayUse }}</div>
            <hr />
            <label
              class="col-4 col-form-label col-form-label-sm text-secondary font-weight-bold d-flex align-items-left justify-content-left"
            >
              Tính chất ngữ pháp
            </label>
            <div>{{ grItem.literaryNature }}</div>
            <hr />
            <label
              class="col-4 col-form-label col-form-label-sm text-primary font-weight-bold d-flex align-items-left justify-content-left"
            >
              Ví dụ
            </label>
            <div
              v-for="ex in listEx"
              :key="ex.id"
              class="col col-form-label col-form-label-sm text-secondary align-items-left justify-content-left"
            >
              <p class="text-left">{{ ex }}</p>
            </div>
          </div>
        </div>
      </div>
    </b-container>
  </div>
</template>
<script>
export default {
  components: {},
};
</script>
<style>
</style>
