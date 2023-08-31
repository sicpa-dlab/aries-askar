package aries_askar


import okio.Buffer


sealed class ErrorCode(message: String): Exception(message) {

    
    class Success(
        message: String
        ) : ErrorCode(message)
    
    class Backend(
        message: String
        ) : ErrorCode(message)
    
    class Busy(
        message: String
        ) : ErrorCode(message)
    
    class Duplicate(
         message: String
        ) : ErrorCode(message)
    
    class Encryption(
         message: String
        ) : ErrorCode(message)
    
    class Input(
         message: String
        ) : ErrorCode(message)

    class NotFound(
         message: String
        ) : ErrorCode(message)
    
    class Unexpected(
         message: String
        ) : ErrorCode(message)
    
    class Unsupported(
         message: String
        ) : ErrorCode(message)
    
    class Custom(
         message: String
        ) : ErrorCode(message)
    

    companion object ErrorHandler : CallStatusErrorHandler<ErrorCode> {
        override fun lift(errorBuffer: RustBuffer): ErrorCode = FfiConverterTypeErrorCode.lift(errorBuffer)
    }

    
}

object FfiConverterTypeErrorCode : FfiConverterRustBuffer<ErrorCode> {
    override fun read(source: NoCopySource): ErrorCode {
        

        return when(source.readInt()) {
            1 -> ErrorCode.Success(
                FfiConverterString.read(source),
                )
            2 -> ErrorCode.Backend(
                FfiConverterString.read(source),
                )
            3 -> ErrorCode.Busy(
                FfiConverterString.read(source),
                )
            4 -> ErrorCode.Duplicate(
                FfiConverterString.read(source),
                )
            5 -> ErrorCode.Encryption(
                FfiConverterString.read(source),
                )
            6 -> ErrorCode.Input(
                FfiConverterString.read(source),
                )
            7 -> ErrorCode.NotFound(
                FfiConverterString.read(source),
                )
            8 -> ErrorCode.Unexpected(
                FfiConverterString.read(source),
                )
            9 -> ErrorCode.Unsupported(
                FfiConverterString.read(source),
                )
            10 -> ErrorCode.Custom(
                FfiConverterString.read(source),
                )
            else -> throw RuntimeException("invalid error enum value, something is very wrong!!")
        }
    }

    override fun allocationSize(value: ErrorCode): Int {
        return when(value) {
            is ErrorCode.Success -> (
                4
                + FfiConverterString.allocationSize(value.message!!)
            )
            is ErrorCode.Backend -> (
                4
                + FfiConverterString.allocationSize(value.message!!)
            )
            is ErrorCode.Busy -> (
                4
                + FfiConverterString.allocationSize(value.message!!)
            )
            is ErrorCode.Duplicate -> (
                4
                + FfiConverterString.allocationSize(value.message!!)
            )
            is ErrorCode.Encryption -> (
                4
                + FfiConverterString.allocationSize(value.message!!)
            )
            is ErrorCode.Input -> (
                4
                + FfiConverterString.allocationSize(value.message!!)
            )
            is ErrorCode.NotFound -> (
                4
                + FfiConverterString.allocationSize(value.message!!)
            )
            is ErrorCode.Unexpected -> (
                4
                + FfiConverterString.allocationSize(value.message!!)
            )
            is ErrorCode.Unsupported -> (
                4
                + FfiConverterString.allocationSize(value.message!!)
            )
            is ErrorCode.Custom -> (
                4
                + FfiConverterString.allocationSize(value.message!!)
            )
        }
    }

    override fun write(value: ErrorCode, buf: Buffer) {
        when(value) {
            is ErrorCode.Success -> {
                buf.writeInt(1)
                FfiConverterString.write(value.message!!, buf)
                Unit
            }
            is ErrorCode.Backend -> {
                buf.writeInt(2)
                FfiConverterString.write(value.message!!, buf)
                Unit
            }
            is ErrorCode.Busy -> {
                buf.writeInt(3)
                FfiConverterString.write(value.message!!, buf)
                Unit
            }
            is ErrorCode.Duplicate -> {
                buf.writeInt(4)
                FfiConverterString.write(value.message!!, buf)
                Unit
            }
            is ErrorCode.Encryption -> {
                buf.writeInt(5)
                FfiConverterString.write(value.message!!, buf)
                Unit
            }
            is ErrorCode.Input -> {
                buf.writeInt(6)
                FfiConverterString.write(value.message!!, buf)
                Unit
            }
            is ErrorCode.NotFound -> {
                buf.writeInt(7)
                FfiConverterString.write(value.message!!, buf)
                Unit
            }
            is ErrorCode.Unexpected -> {
                buf.writeInt(8)
                FfiConverterString.write(value.message!!, buf)
                Unit
            }
            is ErrorCode.Unsupported -> {
                buf.writeInt(9)
                FfiConverterString.write(value.message!!, buf)
                Unit
            }
            is ErrorCode.Custom -> {
                buf.writeInt(10)
                FfiConverterString.write(value.message!!, buf)
                Unit
            }
        }
    }

}