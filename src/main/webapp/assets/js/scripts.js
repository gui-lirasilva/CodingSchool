$('.switch-status').click(function (){
    const tr = this.closest('tr');
    const code = $(tr).data('codeSubcategory');
    const activeStatus = $(tr).children('.activeStatus');
    const button = $(this);
    $.post('/admin/subcategories/'+ code +'/switchVisibility',() => {
        button.hide()
        activeStatus.text('INATIVA')
    });
})

$('.switch-categoryStatus').click(function (){
    const tr = this.closest('tr');
    const code = $(tr).data('codeCategory');
    const activeStatus = $(tr).children('.activeStatus');
    const button = $(this);
    $.post('/admin/categories/'+ code +'/switchVisibility',() => {
        button.hide()
        activeStatus.text('INATIVA')
    });
})