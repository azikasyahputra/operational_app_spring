$(document).ready(function() {
    // Activate PJAX for links with a "pjax-link" class
    $(document).pjax('a.pjax-link', '#pjax-container', {
        fragment: '#pjax-container', // The container to be replaced
        timeout: 5000                // Timeout in milliseconds (optional)
    });

     // Activate PJAX for form submissions with a "pjax-form" class
    $(document).on('submit', 'form.pjax-form', function(event) {
        event.preventDefault();  // Prevent default form submission
        $.pjax.submit(event, '#pjax-container', {
            fragment: '#pjax-container',  // The container to be replaced
            timeout: 5000                 // Timeout in milliseconds (optional)
        });
    });

    // Handle PJAX events for loading and completion
    $(document).on('pjax:start', function() {
        $('#loading-spinner').show();  // Show loading spinner when PJAX starts
    });

    $(document).on('pjax:end', function() {
        $('#loading-spinner').hide();  // Hide loading spinner when PJAX finishes
    });
});
