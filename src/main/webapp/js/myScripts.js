$(document).ready(function(){
   $('#add_answer').click(function(){
      // var title = $('#answer_title').val();
       //var type = $('#answer_type').val();

       var select = '<select class="form-control"><option value="one">Radio</option><option value="many">Checkbox</option></select>';
       var order = '<input type="number" class="form-control" value="0"/>';
       var button = '<button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> remove</button>';

       $('#table_answers tbody').append("<tr>" +
           '<td><input type="text" placeholder="Title" class="form-control"/></td>' +
           '<td>'+ select +'</td>' +
           '<td>'+ order +'</td>' +
           '<td>' + button + '</td>' +
           '</tr>');

   });
});