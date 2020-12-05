export default {
    getCsvFile: function (response, fileName) {
        const type = response.headers['content-type']
        const blob = new Blob([response.data], { type: type, encoding: 'UTF-8' })
        console.log(blob);
        const link = document.createElement('a')
        link.href = window.URL.createObjectURL(blob)
        link.download = fileName
        link.click();
        link.remove();
    },

    downloadFile(response, filename) {
        // It is necessary to create a new blob object with mime-type explicitly set
        // otherwise only Chrome works like it should
        var newBlob = new Blob([response.body], {type: 'application/pdf'})
      
        // IE doesn't allow using a blob object directly as link href
        // instead it is necessary to use msSaveOrOpenBlob
        if (window.navigator && window.navigator.msSaveOrOpenBlob) {
          window.navigator.msSaveOrOpenBlob(newBlob)
          return
        }
      
        // For other browsers:
        // Create a link pointing to the ObjectURL containing the blob.
        const data = window.URL.createObjectURL(newBlob)
        var link = document.createElement('a')
        link.href = data
        link.download = filename + '.pdf'
        link.click()
        setTimeout(function () {
          // For Firefox it is necessary to delay revoking the ObjectURL
          window.URL.revokeObjectURL(data)
        }, 100)
      },

      makeToast(variant = null) {
        this.$bvToast.toast("登録が正常に完了です。", {
          title: `Variant ${variant || "default"}`,
          variant: variant,
          solid: true,
        });
      },

}
