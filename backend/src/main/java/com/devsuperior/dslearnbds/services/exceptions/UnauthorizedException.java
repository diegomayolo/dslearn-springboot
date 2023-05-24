package com.devsuperior.dslearnbds.services.exceptions;

/**
 *
 * @author dm
 */
public class UnauthorizedException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public UnauthorizedException( String msg )
    {
        super( msg );
    }
}

