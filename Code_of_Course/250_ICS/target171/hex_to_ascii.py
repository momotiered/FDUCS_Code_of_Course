hex_string = "59b997fa"
ascii_chars = bytes.fromhex(hex_string).decode('latin1')
print(f"十六进制字符串: {hex_string}")
print(f"ASCII 字符: {ascii_chars}") 