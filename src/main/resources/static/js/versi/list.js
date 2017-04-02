/**
 * Created by ciazhar on 4/1/17.
 */

var app = angular.module ('versiapp',[]);

app.controller('versiController',function ($scope, $http, $window) {
    $scope.daftarVersi = {};

    $scope.listVersi = function(){
        $http.get('/api/versi').then(sukses,gagal);
        function sukses(response) {
            $scope.daftarVersi = response.data;
        }
        function gagal(response) {
            console.log('Error : '+response);
        }
    };
    $scope.listVersi();

    // $scope.hapusVersi = function(versi){
    //     $http.delete('/api/versi/'+versi.id_versi).then(sukses, gagal);
    //     function sukses(response){
    //         $scope.listVersi();
    //     }
    //     function gagal(response){
    //         console.log('Error'+response);
    //     };
    // };
    //
    // var urlRedirect = "http://localhost:8080/versi/form";
    // $scope.editVersi = function (versi) {
    //     $window.location.href = urlRedirect;
    //     $window.sessionStorage.setItem('id',versi.id_versi);
    // }
    //
    // var urlDetilVersi = "http://localhost:8080/versi";
    // $scope.detilVersi = function (versi) {
    //     $window.location.href = urlDetilVersi+versi.id_versi;
    //     $window.sessionStorage.setItem('id',versi.id_versi);
    // }
})

// app.controller('formController',function ($scope, $http, $window) {
//     var urlListVersi = "http://localhost:8080/versi/list";
//     var idnya = $window.sessionStorage.getItem('id');
//
//     $scope.formVersi = function () {
//         $http.get('/api/versi/'+idnya).then(sukses, gagal);
//         function sukses(response){
//             $scope.findedVersi = response.data;
//         }
//         function gagal(response){
//             console.log('Error'+response);
//         };
//         delete sessionStorage.id;/// delete id agar tidak terjadi redundan
//     };
//     $scope.formVersi();
//
//     $scope.simpanVersi = function () {
//         ///Kondisi ini untuk mengantisipasi tidak terdeteksinya value di field sehingga tidak menjadi json utuh
//         $scope.versi.id_versi = $scope.findedVersi.id_versi;
//         if ($scope.versi.nama_versi == null){
//             $scope.versi.nama_versi = $scope.findedVersi.nama_versi;
//         }
//         if ($scope.versi.status_rilis_versi == null){
//             $scope.versi.status_rilis_versi = $scope.findedVersi.status_rilis_versi;
//         }
//
//         $http.post('/api/versi', $scope.versi).then(sukses,gagal);
//         function sukses(response) {
//             $window.location.href = urlListVersi;
//         };
//         function gagal(response) {
//             console.log('Error'+response);
//         };
//     };
// })