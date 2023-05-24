package com.devsuperior.dslearnbds.resources.exceptions;

import com.devsuperior.dslearnbds.services.exceptions.DatabaseException;
import com.devsuperior.dslearnbds.services.exceptions.ForbiddenException;
import com.devsuperior.dslearnbds.services.exceptions.ResourceNotFoundException;
import com.devsuperior.dslearnbds.services.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler
{
    /**
     * entityNotFound
     *
     * @param e ResourceNotFoundException
     * @param request HttpServletRequest
     * @return ResponseEntity<StandardError>
     */
    @ExceptionHandler( ResourceNotFoundException.class )
    public ResponseEntity<StandardError> entityNotFound( ResourceNotFoundException e, HttpServletRequest request )
    {
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError error = new StandardError();
        error.setTimestamp( Instant.now() );
        error.setStatus( status.value() );
        error.setError( "Resource not found" );
        error.setMessage( e.getMessage() );
        error.setPath( request.getRequestURI() );

        return ResponseEntity.status( status ).body( error );
    }

    /**
     * database
     *
     * @param e DatabaseException
     * @param request HttpServletRequest
     * @return ResponseEntity<StandardError>
     */
    @ExceptionHandler( DatabaseException.class )
    public ResponseEntity<StandardError> database( DatabaseException e, HttpServletRequest request )
    {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError error = new StandardError();
        error.setTimestamp( Instant.now() );
        error.setStatus( status.value() );
        error.setError( "Database exception" );
        error.setMessage( e.getMessage() );
        error.setPath( request.getRequestURI() );

        return ResponseEntity.status( status ).body( error );
    }

    /**
     * validation
     *
     * @param e MethodArgumentNotValidException
     * @param request HttpServletRequest
     * @return ResponseEntity<ValidationError>
     */
    @ExceptionHandler( MethodArgumentNotValidException.class )
    public ResponseEntity<ValidationError> validation( MethodArgumentNotValidException e, HttpServletRequest request )
    {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        ValidationError error = new ValidationError();
        error.setTimestamp( Instant.now() );
        error.setStatus( status.value() );
        error.setError( "Validation exception" );
        error.setMessage( e.getMessage() );

        for( FieldError fieldError : e.getBindingResult().getFieldErrors() )
        {
            error.addError( fieldError.getField(), fieldError.getDefaultMessage() );
        }

        error.setPath( request.getRequestURI() );

        return ResponseEntity.status( status ).body( error );
    }

    /**
     * forbidden
     *
     * @param e ForbiddenException
     * @param request HttpServletRequest
     * @return ResponseEntity<OAuthCustomError>
     */
    @ExceptionHandler( ForbiddenException.class )
    public ResponseEntity<OAuthCustomError> forbidden( ForbiddenException e, HttpServletRequest request )
    {
        OAuthCustomError error = new OAuthCustomError( "Forbidden", e.getMessage() );

        return ResponseEntity.status( HttpStatus.FORBIDDEN ).body( error );
    }

    /**
     * unauthorized
     *
     * @param e UnauthorizedException
     * @param request HttpServletRequest
     * @return ResponseEntity<OAuthCustomError>
     */
    @ExceptionHandler( UnauthorizedException.class )
    public ResponseEntity<OAuthCustomError> unauthorized( UnauthorizedException e, HttpServletRequest request )
    {
        OAuthCustomError error = new OAuthCustomError( "Unauthorized", e.getMessage() );

        return ResponseEntity.status( HttpStatus.UNAUTHORIZED ).body( error );
    }
}
