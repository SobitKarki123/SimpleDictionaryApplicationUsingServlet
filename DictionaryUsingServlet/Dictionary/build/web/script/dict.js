/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

     $(document).on("click", "#searchButton", function () {

        $.ajax({
            url: "dictServlet",
            data: {
                "search": $("#searchTermText").val()
            },
            type: "GET",
            success: function (result) {
                                
                var count = 0;
                var html = "";
                html += "<table class='table table-striped'><thead><tr><th>Word</th><th>wordtype</th><th>Definition</th></tr></thead><tbody>";
                $.each(result, function (key, value) {
                    html += "<tr> <td>" + value.word + "</td> <td>"
                            + value.wordtype + "</td> <td>"
                            + value.definition + "</td>  </tr>";
                    count++;
                })

                var query = $("#searchTermText").val();
                html += "</tbody></table>";

                if (count == 0) {
                    $('#resultsDiv').html(
                            "<br>" + "No Results Found :(");
                } else {
                    $('#resultsDiv').html(html);
                }





            }
        });
0
    });



});