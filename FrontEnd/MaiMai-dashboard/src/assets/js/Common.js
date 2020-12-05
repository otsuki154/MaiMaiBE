// export default {
//     getCsvFile: function (response, fileName) { 
//         const type = response.headers['content-type']
//             const blob = new Blob([response.data], { type: type, encoding: 'UTF-8' })
//             const link = document.createElement('a')
//             link.href = window.URL.createObjectURL(blob)
//             link.download = fileName
//             link.click();
//             link.remove();
//      }
// }