$(document).ready(function () {

    /**
     * Adding new answer
     */
    $('#add_answer').click(function () {
        var id = parseInt($('#table_answers tr').last().attr('res-id')) + 1;
        var newRow = $('#table_answers .hidden_row').clone();
        newRow.html(newRow.html().replace(/res-id/g, id));
        $('#table_answers tbody').append(newRow);
        newRow.fadeOut(0).removeClass('hidden_row').attr('res-id', id).fadeIn(500);
    });


    /**
     * Removing the answer from quiz
     */
    $('#table_answers').on('click', '.remove-row-button', function(){
        $(this).parent('td').parent('tr').fadeOut(300, function(){
           $(this).remove();
        });
    });


    /**
     * On saving the quiz dto
     */
    $("#save_quiz_form").click(function(){
        $('#table_answers .hidden_row').empty();
        return true;
    });


});