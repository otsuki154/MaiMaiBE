<template>
  <div class="grammar">
    <!-- <button type="button" class="btn btn-outline-success" @click="getInfo()">
      GetInfor
    </button> -->

    <!-- <button type="button" class="btn btn-outline-success" @click="printPdf()">
      PrintPdf
    </button> -->
    <!-- <input
      type="file"
      id="csvFile"
      name="csvFile"
      class="form-control-sm w-100"
      ref="files"
      v-on:change="handleUpload()"
    />
    <button type="button" class="btn btn-outline-success" @click="upload()">
      Up
    </button>
    <hr /> -->
    <!-- <div class="row">
      <div class="col-3 border border-success shadow p-1 rounded">
        <input class="col border border-success rounded" placeholder="search" v-model="filterText" />
      </div>
      <div class="col-1">
        <button type="button" class="btn btn-outline-success" @click="search()">
          Search
        </button>
      </div>
    </div> -->
    <!-- <div class="row border border-success shadow p-20 mb-6 rounded">
      <h1
        class="text-success font-weight-bold d-flex align-items-center justify-content-center"
      >
        Học thầy không tày học web của ba bé Mai
      </h1>
    </div> -->
    <div class="row">
      <div class="col-3 border border-success shadow p-2 mb-6 rounded">
        <div
          v-for="item in initdata"
          :key="item.id"
          class="border border-success shadow p-1 mb-1 rounded link"
        >
          <a
            href="javascript:void(0)"
            class="href-style text-left text-success"
            @click="clickContent(item)"
          >
            {{ item.grammarContent }}
          </a>
        </div>
      </div>
      <div class="col border border-success shadow pl-2 ml-2 rounded">
        <div class="col shadow p-60 mb-6 rounded">
          <div v-if="isDisplay" class="col">
            <label
              class="col-4 col-form-label col-form-label-sm text-secondary font-weight-bold d-flex align-items-left justify-content-left"
            >
              Ngữ pháp
            </label>
            <div class="text-primary">{{ grItem.grammarContent }}</div>
            <hr />
            <label
              class="col-4 col-form-label col-form-label-sm text-secondary font-weight-bold d-flex align-items-left justify-content-left"
            >
              Nghĩa
            </label>
            <div class="text-danger font-weight-light">{{ grItem.meanVi }}</div>
            <hr />
            <label
              class="col-4 col-form-label col-form-label-sm text-secondary font-weight-bold d-flex align-items-left justify-content-left"
            >
              Ý Nghĩa, Chức Năng
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
              class="col col-form-label col-form-label-sm text-success align-items-left justify-content-left"
            >
              <h6 class="text-left">{{ ex }}</h6>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
/*
 * Import libs and componnents
 */

import axios from "axios";
import Common from "../../../assets/js/Common";
// import EventBus from "../../../assets/js/eventBus";

export default {
  /*
   * Name of component
   */
  name: "grammar",
  /*
   * Declare components
   */
  components: {},
  /*
   * Declare variable and set default value
   */
  data() {
    return {
      initdata: {},
      msg: "",
      files: [],
      grItem: {},
      grDataFilter: {},
      listEx: {},
      isDisplay: false,
      filterText: "",
    };
  },
  /*
   * Initialize
   */
  mounted() {
    this.msg = this.$route.path;
    axios
      .get("http://localhost:2508/grammar/get")
      .then(
        function (response) {
          this.initdata = response.data;

          // Common.getCsvFile(response, `${+new Date()}.csv`);
        }.bind(this)
      )
      .catch(function (error) {
        console.log(error);
      });
  },
  /*
   * Methods
   */
  methods: {
    getInfo() {
      axios
        .get("http://localhost:2508/grammar/get")
        .then(
          function (response) {
            this.data = response.data;

            // Common.getCsvFile(response, `${+new Date()}.csv`);
          }.bind(this)
        )
        .catch(function (error) {
          console.log(error);
        });
    },
    printPdf() {
      axios
        .get("http://localhost:2508/grammar/print2")
        .then(
          function (response) {
            console.log(response.data);
            // Common.getCsvFile(response,`${+ new Date()}.pdf`);
            // Common.downloadFile(response,"filetest")
            //  var filename = response.headers.get('content-disposition').split('=')[1]
            const blob = new Blob([response.data], { type: "application/pdf" });
            const link = document.createElement("a");
            link.href = URL.createObjectURL(blob);
            link.download = "label.pdf";
            link.click();
            URL.revokeObjectURL(link.href);
          }.bind(this)
        )
        .catch(function (error) {
          console.log(error);
        });
    },
    handleUpload() {
      var _this = this;
      _this.files = [];
      // eslint-disable-next-line
      let uploadedFiles = _this.$refs.files.files;
      for (var i = 0; i < uploadedFiles.length; i++) {
        _this.files.push(uploadedFiles[i]);
      }
      console.log(_this.files);
    },
    upload() {
      var _this = this;
      let formData = new FormData();
      for (var i = 0; i < _this.files.length; i++) {
        let file = _this.files[i];
        formData.append("files", file);
      }
      axios
        .post("http://localhost:2508/grammar/upcsv", formData, {
          headers: { "Content-Type": "multipart/form-data" },
        })
        .then(
          function (response) {
            console.log(response.data);
            if (response.data === "OK") {
              Common.makeToast("success");
            }
          }.bind(this)
        )
        .catch(function (error) {
          console.log(error);
        });
    },
    clickContent(item) {
      // console.log(item);
      this.grItem = item;
      this.isDisplay = true;
      this.listEx = item.example.split("★");
      window.scrollTo(0, 0);
    },
    search() {
      console.log(this.filterText);
      this.grDataFilter = this.initdata.grammarContent.filter((v) =>
        v.match(this.filterText)
      );
      console.log(this.grDataFilter);
    },
  },
};
</script>

<style scoped>
</style>