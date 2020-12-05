<template>
  <div class="use-infor">
    <div class="container">
      <div class="row mt-3 mb-3">
        <div class="col">
          <div class="form-submit-outside">
            <div class="card">
              <div class="card-header p-0 bg-success">
                <h5 class="mb-0 d-flex">
                  <!-- 検索機能 -->
                  <button
                    class="btn btn-sm btn-link text-white order-1"
                    type="button"
                    data-toggle="collapse"
                    data-target="#collapseTwo"
                    aria-expanded="true"
                    aria-controls="collapseTwo"
                  >
                    検索
                  </button>
                  <!-- <button
                    class="btn btn-sm btn-link collapse-icon-only"
                    type="button"
                    data-toggle="collapse"
                    data-target="#collapseTwo"
                    aria-expanded="true"
                    aria-controls="collapseTwo"
                  >
                    <i
                      class="fa text-white fa-chevron-up"
                      id="collapseOne1"
                    ></i>
                  </button> -->
                </h5>
              </div>
              <div class="card-body collapse show" id="collapseTwo">
                <form class="">
                  <div class="row m-0 mx-n1 mb-n1">
                    <!-- ITEM -->
                    <div class="col-12 col-sm-6 col-md-6 col-lg-4 mb-1 px-2">
                      <div
                        class="form-row with-label-background align-items-start"
                      >
                        <!-- 商品コード -->
                        <label
                          class="col-4 col-form-label col-form-label-sm"
                          id="searchSItemCdS_lbl"
                          >商品コード</label
                        >
                        <div class="col p-0">
                          <div class="form-row">
                            <div class="col">
                              <select
                                class="selectpicker form-control form-control-sm"
                                v-model="shohin"
                              >
                                <option
                                  v-for="itemKbn in itemKbnList"
                                  :key="itemKbn.id"
                                  :value="itemKbn.id"
                                >
                                  {{ itemKbn.name }}
                                </option>
                              </select>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="col-12 col-md-auto align-self-end pl-md-0 mt-2 mt-md-0">
          <div class="form-row">
            <!-- 検索 -->
            <div class="col-auto">
              <button
                class="col btn btn-sm btn-outline-success"
                @click="search()"
              >
                検索
              </button>
            </div>
            <!-- 新規登録 -->
            <div class="col-auto pl-0">
              <button
                class="col btn btn-sm btn-outline-success"
                @click="insert()"
              >
                新規登録
              </button>
            </div>
          </div>
        </div>
        <div>
          <b-button v-b-toggle.collapse-1 variant="primary"
            >Toggle Collapse</b-button
          >
          <b-collapse id="collapse-1" class="mt-2">
            <b-card>
              <p class="card-text">Collapse contents Here</p>
              <b-button v-b-toggle.collapse-1-inner size="sm"
                >Toggle Inner Collapse</b-button
              >
              <b-collapse id="collapse-1-inner" class="mt-2">
                <b-card>Hello!</b-card>
              </b-collapse>
            </b-card>
          </b-collapse>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
/*
 * Import libs and componnents
 */
export default {
  /*
   * Name of component
   */
  name: "goi",
  /*
   * Declare components
   */
  components: {},
  /*
   * Declare variable and set default value
   */
  data() {
    return {};
  },
  /*
   * Initialize
   */
  mounted() {},
  /*
   * Methods
   */
  methods: {
    Back2Home() {
      this.$router.push({ path: "/" });
    },
  },
};
</script>

<style scoped>
</style>