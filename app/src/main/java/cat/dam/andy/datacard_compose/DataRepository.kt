package cat.dam.andy.datacard_compose

class DataRepository {
    fun getDataItems(): List<Item> {
        val items = ArrayList<Item>()
        items.add(
            Item(
                1,
                "Pomes",
                "Pomes de l'Empordà. Les millors del món!!!",
                R.drawable.apple,
                3.15
            )
        )
        items.add(
            Item(
                2,
                "Plàtans",
                "Platans de Canàries, ideals per recuperar l'energia!!!",
                R.drawable.banana,
                4.45
            )
        )
        items.add(
            Item(
                3,
                "Peres",
                "Molt bones i amb molt de suc, tenim peres per als amants de les fruites de la millor qualitat",
                R.drawable.pear,
                3.12
            )
        )
        items.add(
            Item(
                4,
                "Maduixes",
                "Maduixes amb gran qualitat i a un preu assequible!!!",
                R.drawable.strawberry,
                5.6
            )
        )
        items.add(
            Item(
                5,
                "Taronges",
                "Veritables taronges de València. Boníssimes!!",
                R.drawable.orange,
                1.2
            )
        )
        items.add(Item(6, "Mandarines", "Mandarines molt dolces", R.drawable.mandarin, 1.18))
        items.add(
            Item(
                7,
                "Pomelos",
                "Pomelos de l'Horta. Els has de provar!!!",
                R.drawable.pomelo,
                5.3
            )
        )
        items.add(
            Item(
                8,
                "Prunes",
                "Si t'agraden les prunes, aquestes són les teves, són boníssimes!!!",
                R.drawable.plum,
                3.2
            )
        )
        items.add(
            Item(
                9,
                "Raïms",
                "No cal que esperis al cap d'any a comprar raïms. Aquests són de la millor qualitat!!!",
                R.drawable.grapes,
                2.3
            )
        )
        items.add(
            Item(
                10,
                "Melons",
                "Melons dolços i refrescants amb la qualitat garantida!!!",
                R.drawable.muskmelon,
                1.03
            )
        )

        return items
    }
}