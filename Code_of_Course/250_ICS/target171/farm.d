
farm.o:     file format elf64-x86-64


Disassembly of section .text:

0000000000000000 <start_farm>:
   0:	f3 0f 1e fa          	endbr64
   4:	b8 01 00 00 00       	mov    $0x1,%eax
   9:	c3                   	ret

000000000000000a <addval_272>:
   a:	f3 0f 1e fa          	endbr64
   e:	8d 87 4c 89 c7 90    	lea    -0x6f3876b4(%rdi),%eax
  14:	c3                   	ret

0000000000000015 <setval_218>:
  15:	f3 0f 1e fa          	endbr64
  19:	c7 07 58 90 94 c3    	movl   $0xc3949058,(%rdi)
  1f:	c3                   	ret

0000000000000020 <getval_361>:
  20:	f3 0f 1e fa          	endbr64
  24:	b8 48 89 c7 90       	mov    $0x90c78948,%eax
  29:	c3                   	ret

000000000000002a <addval_221>:
  2a:	f3 0f 1e fa          	endbr64
  2e:	8d 87 a0 58 c3 fa    	lea    -0x53ca760(%rdi),%eax
  34:	c3                   	ret

0000000000000035 <setval_202>:
  35:	f3 0f 1e fa          	endbr64
  39:	c7 07 d8 90 90 90    	movl   $0x909090d8,(%rdi)
  3f:	c3                   	ret

0000000000000040 <getval_132>:
  40:	f3 0f 1e fa          	endbr64
  44:	b8 48 8b c7 90       	mov    $0x90c78b48,%eax
  49:	c3                   	ret

000000000000004a <getval_266>:
  4a:	f3 0f 1e fa          	endbr64
  4e:	b8 55 48 89 c7       	mov    $0xc7894855,%eax
  53:	c3                   	ret

0000000000000054 <addval_216>:
  54:	f3 0f 1e fa          	endbr64
  58:	8d 87 06 0c 58 90    	lea    -0x6fa7f3fa(%rdi),%eax
  5e:	c3                   	ret

000000000000005f <mid_farm>:
  5f:	f3 0f 1e fa          	endbr64
  63:	b8 01 00 00 00       	mov    $0x1,%eax
  68:	c3                   	ret

0000000000000069 <add_xy>:
  69:	f3 0f 1e fa          	endbr64
  6d:	48 8d 04 37          	lea    (%rdi,%rsi,1),%rax
  71:	c3                   	ret

0000000000000072 <addval_252>:
  72:	f3 0f 1e fa          	endbr64
  76:	8d 87 89 d6 48 db    	lea    -0x24b72977(%rdi),%eax
  7c:	c3                   	ret

000000000000007d <getval_488>:
  7d:	f3 0f 1e fa          	endbr64
  81:	b8 48 89 e0 94       	mov    $0x94e08948,%eax
  86:	c3                   	ret

0000000000000087 <addval_269>:
  87:	f3 0f 1e fa          	endbr64
  8b:	8d 87 68 89 e0 90    	lea    -0x6f1f7698(%rdi),%eax
  91:	c3                   	ret

0000000000000092 <getval_483>:
  92:	f3 0f 1e fa          	endbr64
  96:	b8 48 89 e0 c3       	mov    $0xc3e08948,%eax
  9b:	c3                   	ret

000000000000009c <getval_340>:
  9c:	f3 0f 1e fa          	endbr64
  a0:	b8 89 d6 90 c3       	mov    $0xc390d689,%eax
  a5:	c3                   	ret

00000000000000a6 <addval_196>:
  a6:	f3 0f 1e fa          	endbr64
  aa:	8d 87 89 d6 c4 d2    	lea    -0x2d3b2977(%rdi),%eax
  b0:	c3                   	ret

00000000000000b1 <getval_346>:
  b1:	f3 0f 1e fa          	endbr64
  b5:	b8 89 ca 20 d2       	mov    $0xd220ca89,%eax
  ba:	c3                   	ret

00000000000000bb <setval_497>:
  bb:	f3 0f 1e fa          	endbr64
  bf:	c7 07 89 d6 c4 c9    	movl   $0xc9c4d689,(%rdi)
  c5:	c3                   	ret

00000000000000c6 <addval_353>:
  c6:	f3 0f 1e fa          	endbr64
  ca:	8d 87 89 c1 90 c2    	lea    -0x3d6f3e77(%rdi),%eax
  d0:	c3                   	ret

00000000000000d1 <setval_170>:
  d1:	f3 0f 1e fa          	endbr64
  d5:	c7 07 48 c9 e0 90    	movl   $0x90e0c948,(%rdi)
  db:	c3                   	ret

00000000000000dc <setval_386>:
  dc:	f3 0f 1e fa          	endbr64
  e0:	c7 07 88 c1 38 db    	movl   $0xdb38c188,(%rdi)
  e6:	c3                   	ret

00000000000000e7 <getval_308>:
  e7:	f3 0f 1e fa          	endbr64
  eb:	b8 8d ca 90 90       	mov    $0x9090ca8d,%eax
  f0:	c3                   	ret

00000000000000f1 <setval_290>:
  f1:	f3 0f 1e fa          	endbr64
  f5:	c7 07 62 84 c9 ca    	movl   $0xcac98462,(%rdi)
  fb:	c3                   	ret

00000000000000fc <setval_357>:
  fc:	f3 0f 1e fa          	endbr64
 100:	c7 07 89 c1 90 90    	movl   $0x9090c189,(%rdi)
 106:	c3                   	ret

0000000000000107 <setval_231>:
 107:	f3 0f 1e fa          	endbr64
 10b:	c7 07 89 d6 20 c9    	movl   $0xc920d689,(%rdi)
 111:	c3                   	ret

0000000000000112 <addval_270>:
 112:	f3 0f 1e fa          	endbr64
 116:	8d 87 89 d6 a4 d2    	lea    -0x2d5b2977(%rdi),%eax
 11c:	c3                   	ret

000000000000011d <setval_102>:
 11d:	f3 0f 1e fa          	endbr64
 121:	c7 07 88 ca 20 d2    	movl   $0xd220ca88,(%rdi)
 127:	c3                   	ret

0000000000000128 <setval_219>:
 128:	f3 0f 1e fa          	endbr64
 12c:	c7 07 89 c1 84 c9    	movl   $0xc984c189,(%rdi)
 132:	c3                   	ret

0000000000000133 <addval_461>:
 133:	f3 0f 1e fa          	endbr64
 137:	8d 87 d7 48 89 e0    	lea    -0x1f76b729(%rdi),%eax
 13d:	c3                   	ret

000000000000013e <addval_301>:
 13e:	f3 0f 1e fa          	endbr64
 142:	8d 87 91 0a 99 ca    	lea    -0x3566f56f(%rdi),%eax
 148:	c3                   	ret

0000000000000149 <getval_298>:
 149:	f3 0f 1e fa          	endbr64
 14d:	b8 08 89 e0 c3       	mov    $0xc3e08908,%eax
 152:	c3                   	ret

0000000000000153 <getval_445>:
 153:	f3 0f 1e fa          	endbr64
 157:	b8 89 c1 c7 7e       	mov    $0x7ec7c189,%eax
 15c:	c3                   	ret

000000000000015d <getval_157>:
 15d:	f3 0f 1e fa          	endbr64
 161:	b8 89 ca 90 90       	mov    $0x9090ca89,%eax
 166:	c3                   	ret

0000000000000167 <addval_110>:
 167:	f3 0f 1e fa          	endbr64
 16b:	8d 87 89 ca c7 1d    	lea    0x1dc7ca89(%rdi),%eax
 171:	c3                   	ret

0000000000000172 <getval_224>:
 172:	f3 0f 1e fa          	endbr64
 176:	b8 aa d5 99 d6       	mov    $0xd699d5aa,%eax
 17b:	c3                   	ret

000000000000017c <addval_427>:
 17c:	f3 0f 1e fa          	endbr64
 180:	8d 87 36 09 c1 90    	lea    -0x6f3ef6ca(%rdi),%eax
 186:	c3                   	ret

0000000000000187 <setval_495>:
 187:	f3 0f 1e fa          	endbr64
 18b:	c7 07 48 89 e0 c1    	movl   $0xc1e08948,(%rdi)
 191:	c3                   	ret

0000000000000192 <getval_288>:
 192:	f3 0f 1e fa          	endbr64
 196:	b8 89 c1 c1 ae       	mov    $0xaec1c189,%eax
 19b:	c3                   	ret

000000000000019c <getval_327>:
 19c:	f3 0f 1e fa          	endbr64
 1a0:	b8 68 89 e0 c3       	mov    $0xc3e08968,%eax
 1a5:	c3                   	ret

00000000000001a6 <setval_277>:
 1a6:	f3 0f 1e fa          	endbr64
 1aa:	c7 07 a9 9f 09 d6    	movl   $0xd6099fa9,(%rdi)
 1b0:	c3                   	ret

00000000000001b1 <setval_207>:
 1b1:	f3 0f 1e fa          	endbr64
 1b5:	c7 07 99 ca 08 d2    	movl   $0xd208ca99,(%rdi)
 1bb:	c3                   	ret

00000000000001bc <addval_279>:
 1bc:	f3 0f 1e fa          	endbr64
 1c0:	8d 87 81 c1 90 c3    	lea    -0x3c6f3e7f(%rdi),%eax
 1c6:	c3                   	ret

00000000000001c7 <end_farm>:
 1c7:	f3 0f 1e fa          	endbr64
 1cb:	b8 01 00 00 00       	mov    $0x1,%eax
 1d0:	c3                   	ret
