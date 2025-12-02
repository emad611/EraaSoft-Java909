List<Optional<String>> optionals = Arrays.asList(
        Optional.of("Ali"),
        Optional.empty(),
        Optional.of("Omar")
);

// استخراج القيم غير الفارغة فقط
List<String> nonEmpty = optionals.stream()
        .filter(Optional::isPresent)                 // نختار اللي فيها قيمة
        .map(Optional::get)                          // استخراج القيمة من الـ Optional
        .collect(Collectors.toList());

System.out.println(nonEmpty); // [Ali, Omar]
