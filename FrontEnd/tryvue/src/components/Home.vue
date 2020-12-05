<template>
  <div class="home">
    <h5>{{ msg }}</h5>
    <button type="button" class="btn btn-outline-success" @click="gotoGoi()">
      Go to goi
    </button>

    <button type="button" class="btn btn-outline-success" @click="getInfo()">
      GetInfor
    </button>

    <button type="button" class="btn btn-outline-success" @click="printPdf()">
      PrintPdf
    </button>
    <input
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
    <hr />
    <div class="border border-success shadow p-2 mb-6 rounded">{{ data }}</div>
    <hr />
    <!-- <div v-for="item in data" :key="item.id" class="border border-success shadow p-3 mb-5 bg-white rounded">
      <li>{{ item.userName }}</li>
    </div> -->
  </div>
</template>

<script>
/*
 * Import libs and componnents
 */
import axios from "axios";
import Common from "../assets/js/Common";
import EventBus from "../assets/js/eventBus";

export default {
  /*
   * Name of component
   */
  name: "",
  /*
   * Declare components
   */
  components: {},
  /*
   * Declare variable and set default value
   */
  data() {
    return {
      data: {},
      msg: "",
      files: [],
    };
  },
  /*
   * Initialize
   */
  mounted() {
    var _this = this;
    EventBus.$on("haha", function (data) {
      _this.msg = data;
    });
  },
  /*
   * Methods
   */
  methods: {
    gotoGoi() {
      this.$router.push({ path: "goi" });
    },
    getInfo() {
      axios
        .get("http://localhost:2508/register/csv")
        .then(
          function (response) {
            this.data = response.data;

            Common.getCsvFile(response, `${+new Date()}.csv`);
          }.bind(this)
        )
        .catch(function (error) {
          console.log(error);
        });
    },
    printPdf() {
      axios
        .get("http://localhost:2508/register/print2")
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
        .post("http://localhost:2508/register/upcsv", formData, {
          headers: { "Content-Type": "multipart/form-data" },
        })
        .then(
          function (response) {
            console.log(response.data);
            if (response.data === "OK") {
              Common.makeToast('success');
            }
          }.bind(this)
        )
        .catch(function (error) {
          console.log(error);
        });
    },
    
  },
};
</script>

<style scoped>
</style>
